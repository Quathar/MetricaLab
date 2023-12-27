package com.quathar.metrica.calculator.model;

import java.math.BigInteger;

/**
 * <h1>Operable</h1>
 * <br>
 * <p>
 *     This interface represents an entity capable of basic arithmetic operations on BigIntegers.
 * </p>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public interface Operable {

    /**
     * Retrieves the current value.
     *
     * @return The current value as a BigInteger.
     */
    BigInteger getValue();

    /**
     * Sets the value to the provided BigInteger.
     *
     * @param value The value to set.
     */
    void setValue(BigInteger value);

    /**
     * Adds the provided value to the current value.
     *
     * @param value The value to add.
     */
    void add(BigInteger value);

    /**
     * Subtracts the provided value from the current value.
     *
     * @param value The value to subtract.
     */
    void subtract(BigInteger value);

    /**
     * Multiplies the current value by the provided value.
     *
     * @param value The value to multiply by.
     */
    void multiply(BigInteger value);

    /**
     * Divides the current value by the provided value.
     *
     * @param value The value to divide by.
     */
    void divide(BigInteger value);

}
