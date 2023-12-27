package com.metrica.quathar.restclient;

import com.metrica.quathar.restclient.model.Movie;
import com.metrica.quathar.restclient.model.MovieSearch;

/**
 * <h1>OMDB Client Contract</h1>
 * <br>
 * <p>
 *     Describes the contract for interacting with the OMDB API.
 * </p>
 *
 * @since 2023-10-25
 * @version 1.0
 * @author Q
 */
public interface OmdbClientContract {

    /**
     * Retrieves a movie by its unique identifier.
     *
     * @param id The unique identifier (IMDb ID) of the movie.
     * @return The Movie object corresponding to the provided ID.
     */
    Movie getById(String id);

    /**
     * Retrieves a movie by its title.
     *
     * @param title The title of the movie.
     * @return The Movie object corresponding to the provided title.
     */
    Movie getByTitle(String title);

    /**
     * Searches for movies based on a title.
     *
     * @param title The title used to search for movies.
     * @return A MovieSearch object containing the search results based on the title.
     */
    MovieSearch searchMovieByTitle(String title);

    /**
     * Retrieves the oldest movie by a given title.
     *
     * @param title The title used to find the oldest movie.
     * @return The oldest Movie object corresponding to the provided title.
     */
    Movie getOldestMovieByTitle(String title);

    /**
     * Retrieves the newest movie by a given title.
     *
     * @param title The title used to find the newest movie.
     * @return The newest Movie object corresponding to the provided title.
     */
    Movie getNewestMovieByTitle(String title);

    /**
     * Retrieves a movie with a higher metascore by title.
     *
     * @param title The title used to find the movie with a higher metascore.
     * @return The Movie object with a higher metascore corresponding to the provided title.
     */
    Movie getMoreMetascore(String title);

    /**
     * Closes the resources used by the OMDB client.
     * It is essential to call this method to release resources after use.
     */
    void close();

}
