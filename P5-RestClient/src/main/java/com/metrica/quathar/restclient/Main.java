package com.metrica.quathar.restclient;

import com.metrica.quathar.restclient.model.Movie;
import com.metrica.quathar.restclient.model.MovieSearch;

public class Main {
    
    public static void main(String[] args) {
        // Create the client
        OmdbClient client = new OmdbClient();
        
        // Get the Cocoon movie & print director
        Movie cocoonMovie = client.getByTitle("Cocoon");
        System.out.println("The Cocoon director is " + cocoonMovie.director());
        System.out.println("=".repeat(50));

        // Get the all the movies with 'Spook' in their title
        MovieSearch spookMovies = client.searchMovieByTitle("Spock");
        java.util.stream.IntStream.range(0, spookMovies.search().size())
            .mapToObj(i -> new Object[] {i, spookMovies.search().get(i).title()})
            .forEach(arr -> System.out.printf("%02d - %s%n", arr[0], arr[1]));
        System.out.println("The total results were " + spookMovies.totalResults());
        System.out.println("=".repeat(50));
        
        // Get Older and Newer movie
        Movie oldestMovie = client.getOldestMovieByTitle("Spock");
        System.out.printf("The oldest movie is '%s' from %s and it's director is '%s'%n",
                oldestMovie.title(),
                oldestMovie.year(),
                oldestMovie.director());
        Movie newestMovie = client.getNewestMovieByTitle("Spock");
        System.out.printf("The newest movie is '%s' from %s and it's director is '%s'%n",
                newestMovie.title(),
                newestMovie.year(),
                newestMovie.director());
        System.out.println("=".repeat(50));
        
        // More metascore
        Movie metascore = client.getMoreMetascore("Spock");
        System.out.printf("The movie with more metascore is '%s'", metascore.title());
        
        // Close the client
        client.close();
    }

}
