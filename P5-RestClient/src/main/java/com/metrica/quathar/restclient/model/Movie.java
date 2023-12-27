package com.metrica.quathar.restclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * <h1>Movie Model</h1>
 *
 * @param imdbID    The IMDb ID of the movie.
 * @param title     The title of the movie.
 * @param director  The director of the movie.
 * @param year      The year of release of the movie.
 * @param ratings   The list of ratings received by the movie.
 * @param metascore The metascore of the movie.
 *
 * @since 2023-10-25
 * @version 1.0
 * @author Q
 */
public record Movie (
        @SerializedName("imdbID")
        String imdbID,
        @SerializedName("Title")
        String title,
        @SerializedName("Director")
        String director,
        @SerializedName("Year")
        String year,
        @SerializedName("Ratings")
        java.util.List<Rating> ratings,
        @SerializedName("Metascore")
        String metascore
) {}
