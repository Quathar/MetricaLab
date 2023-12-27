package com.metrica.quathar.restclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * <h1>Rating model</h1>

 * @param source The source of the rating.
 * @param value  The value of the rating.
 *
 * @since 2023-10-25
 * @version 1.0
 * @author Q
 */
public record Rating(
        @SerializedName("Source")
        String source,
        @SerializedName("Value")
        String value
) {}
