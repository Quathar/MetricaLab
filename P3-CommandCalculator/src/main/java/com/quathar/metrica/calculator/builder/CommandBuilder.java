package com.quathar.metrica.calculator.builder;

import com.quathar.metrica.calculator.command.Command;

/**
 * <h1>Command Builder</h1>
 * <br>
 * <p>
 *     Defines a builder responsible for creating specific commands based on a given type.
 * </p>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public interface CommandBuilder {

    /**
     * Checks if the builder accepts the given type for command creation.
     *
     * @param type The type of command.
     * @return {@code true} if the builder accepts the type, {@code false} otherwise.
     */
    boolean accept(final String type);

    /**
     * Builds a command based on the builder's criteria.
     *
     * @return A Command instance created by the builder.
     */
    Command build();

    /**
     * Sets the number associated with the command to be built.
     * This method allows configuring a numerical value for the command.
     *
     * @param number The numerical value to set for the command.
     * @return The CommandBuilder instance with the specified number set.
     */
    CommandBuilder setNumber(java.math.BigInteger number);

}
