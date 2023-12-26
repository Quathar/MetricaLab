package com.quathar.metrica.criteria.othersolution.tester;

/**
 * <h1>Tester</h1>
 * <br>
 * <p>
 *     This functional interface defines a contract for testing values of a specific type.
 * </p>
 *
 * @param <E> The type of value to be tested.
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
@FunctionalInterface
public interface Tester<E> {

    /**
     * Tests the given value based on the defined criteria.
     *
     * @param value The value to be tested.
     * @return {@code true} if the value passes the test, {@code false} otherwise.
     */
    boolean test(E value);

}
