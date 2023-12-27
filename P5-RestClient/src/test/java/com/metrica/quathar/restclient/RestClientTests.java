package com.metrica.quathar.restclient;

import com.metrica.quathar.restclient.model.Movie;
import com.metrica.quathar.restclient.model.MovieSearch;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h1>REST Client Tests</h1>
 *
 * @since 2023-10-25
 * @version 1.0
 * @author Q
 */
class RestClientTests {

    // In general how do you test an API ???

    // <<-FIELD->>
    private final OmdbClient omdbClient = new OmdbClient();

    // <<-TESTS->>
    @Test
    @Order(0)
    void cocoonDirectorTest() {
        Movie movie = this.omdbClient.getByTitle("Cocoon");
        assertEquals("Ron Howard", movie.director());
    }
    
    @Test
    @Order(1)
    void spookTest() {
        // Get the all the movies with 'Spock' in their title
        MovieSearch spookMovies = this.omdbClient.searchMovieByTitle("Spock");
        spookMovies.search().forEach(System.out::println);
        assertEquals(14, spookMovies.totalResults());
    }
    
    @Test
    @Order(2)
    void olderMovieTest() {
        Movie oldestMovie = this.omdbClient.getOldestMovieByTitle("Spock");
        assertEquals("Dr Spock and His Babies", oldestMovie.title());
    }

    @Test
    @Order(3)
    void newerMovieTest() {
        Movie newestMovie = this.omdbClient.getNewestMovieByTitle("Spock");
        assertEquals("I'm Not Spock", newestMovie.title());
    }
    
    @Test
    @Order(4)
    void moreMetascoreTest() {
        Movie metascore = this.omdbClient.getMoreMetascore("Spock");
        assertEquals("Reflections on Spock", metascore.title());
    }

    @Order(5)
    void getClient() {
        this.omdbClient.close();
    }

}
