package com.metrica.quathar.restclient;

import com.google.gson.Gson;

import com.metrica.quathar.restclient.model.Movie;
import com.metrica.quathar.restclient.model.MovieSearch;
import com.metrica.quathar.restclient.model.Rating;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * <h1>OMDB (Open Movie Database) Client</h1>
 *
 * @since 2023-10-25
 * @version 1.0
 * @author Q
 */
public class OmdbClient implements OmdbClientContract {
    
    // <<-CONSTANTS->>
    public static final String OMDB_URI = "http://www.omdbapi.com/?apikey=%s";
    private static final int MAX_ELEMENTS_PER_PAGE = 10;
    
    // <<-FIELDS->>
    private final javax.ws.rs.client.Client client;
    private final javax.ws.rs.client.WebTarget webTarget;

    // <<-CONSTRUCTOR->>
    public OmdbClient() {
        this.client    = javax.ws.rs.client.ClientBuilder.newClient();
        this.webTarget = this.client.target(String.format(OMDB_URI, "[INSERT YOUR API KEY HERE]"));
    }

    // <<-METHODS->>
    @Override
    public Movie getById(String id) {
        String jsonResponse = this.webTarget.queryParam("i", id)
                .request(APPLICATION_JSON)
                .get(String.class);
        return new Gson().fromJson(jsonResponse, Movie.class);
    }

    @Override
    public Movie getByTitle(String title) {
        String jsonResponse = this.webTarget.queryParam("t", title)
                .request(APPLICATION_JSON)
                .get(String.class);
        return new Gson().fromJson(jsonResponse, Movie.class);
    }

    @Override
    public MovieSearch searchMovieByTitle(String title) {
        String jsonResponse = this.webTarget.queryParam("s", title)
                .queryParam("type", "movie")
                .request(APPLICATION_JSON)
                .get(String.class);
        
        Gson gson = new Gson();
        MovieSearch movieSearch = gson.fromJson(jsonResponse, MovieSearch.class);
        
        int total = movieSearch.totalResults();
        if (total > MAX_ELEMENTS_PER_PAGE) {
            int module = total % MAX_ELEMENTS_PER_PAGE;
            int result = total / MAX_ELEMENTS_PER_PAGE;
            int limit  = module == 0 ? result : result + 1;
            java.util.stream.IntStream.rangeClosed(2, limit)
                    .mapToObj(i -> this.webTarget.queryParam("s", title)
                            .queryParam("page", i)
                            .request(APPLICATION_JSON)
                            .get(String.class))
                    .map(response -> gson.fromJson(response, MovieSearch.class))
                    .flatMap(moviesPage -> moviesPage.search().stream())
                    .forEach(movie -> movieSearch.search().add(movie));
        }
        
        return movieSearch;
    }
    
    private int sortByYear(String year1, String year2, boolean increase) {
        String y1 = increase ? year1 : year2;
        String y2 = increase ? year2 : year1;
        
        if ( y1.isEmpty() && y2.isEmpty() ) return 0;
        if ( y1.isEmpty() ) return -1;
        if ( y2.isEmpty() ) return 1;
        return Integer.compare( Integer.valueOf(y1), Integer.valueOf(y2) );
    }

    @Override
    public Movie getOldestMovieByTitle(String title) {
        return this.searchMovieByTitle(title)
                .search()
                .stream()
                .sorted((movie1, movie2) -> {
                    // I use the 'unicode' character cause is not - is –
                    // It seems the same, but it's not
                    String t1 = movie1.year();
                    var year1 = t1.contains("\u2013") ?
                                t1.substring(0, t1.indexOf("\u2013")) : t1;
                    String t2 = movie2.year();
                    var year2 = t2.contains("\u2013") ?
                                t2.substring(0, t2.indexOf("\u2013")) : t2;
                    return this.sortByYear(year1, year2, true);
                }).limit(1)
                .map(movie -> this.getById(movie.imdbID()))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Movie getNewestMovieByTitle(String title) {
        return this.searchMovieByTitle(title)
                .search()
                .stream()
                .sorted((movie1, movie2) -> {
                    // I use the 'unicode' character cause is not - is –
                    // It seems the same, but it's not
                    String t1 = movie1.year();
                    var year1 = t1.contains("\u2013") ?
                                t1.substring(0, t1.indexOf("\u2013")) : t1;
                    String t2 = movie2.year();
                    var year2 = t2.contains("\u2013") ?
                                t2.substring(0, t2.indexOf("\u2013")) : t2;
                    return this.sortByYear(year1, year2, false);
                }).limit(1)
                .map(movie -> this.getById(movie.imdbID()))
                .findFirst()
                .orElseThrow();
    }
    
    private double getRatingScore(Movie movie) {
        double total = 0;
        
        for (Rating rating : movie.ratings()) {
            String value = rating.value();
            if (value.contains("%")) {
                total += Double.valueOf(value.substring(0, value.indexOf("%")));
            } else if (value.contains("/")) {
                String[] arr = value.split("/");
                total += Double.valueOf(arr[0]) * (100 / Integer.valueOf(arr[1]));
            }
        }
        return total / movie.ratings().size();
    }
    
    private boolean isAnnounced(String property) {
        return !property.equals("N/A");
    }
    
    private int byMetascore(Movie movie1, Movie movie2) {
        String meta1 = movie1.metascore();
        String meta2 = movie2.metascore();
        if (!isAnnounced(meta1) && !isAnnounced(meta2))
            return Double.compare(getRatingScore(movie2), getRatingScore(movie1));
        if (!isAnnounced(meta1)) return -1;
        if (!isAnnounced(meta2)) return 1;
        // Decremental order
        return Double.compare(Double.valueOf(meta2), Double.valueOf(meta1));
    }

    @Override
    public Movie getMoreMetascore(String title) {
        return this.searchMovieByTitle(title)
                .search()
                .stream()
                .map(movie -> this.getById(movie.imdbID()))
                .filter(movie -> isAnnounced(movie.metascore())
                        || (!isAnnounced(movie.metascore()) && !movie.ratings().isEmpty()))
                .min(this::byMetascore)
                .orElseThrow();
    }

    @Override
    public void close() {
        this.client.close();
    }
    
}
