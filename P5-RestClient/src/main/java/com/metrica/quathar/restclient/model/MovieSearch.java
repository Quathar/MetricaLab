package com.metrica.quathar.restclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * <h1>Movie Search Model</h1>
 *
 * @param search       The list of movies resulting from the search.
 * @param totalResults The total number of search results.
 *
 * @since 2023-10-25
 * @version 1.0
 * @author Q
 */
public record MovieSearch(
        @SerializedName("Search")
        java.util.List<Movie> search,
        @SerializedName("totalResults")
        int totalResults
) {}
