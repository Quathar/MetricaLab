package com.quathar.metrica.criteria.factory;

import com.quathar.metrica.criteria.Criteria;

/**
 * <h1>Criteria Builder</h1>
 * <br>
 * <p>
 *     This abstract class represents a builder for creating Criteria objects.
 *     Implementations should extend this class and provide logic to build
 *     specific Criteria instances.
 * </p>
 *
 * @param <E> The type of Criteria this builder constructs.
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public abstract class CriteriaBuilder<E extends Criteria<?>> {

    // <<-FIELD->>
    private final String type;

    // <<-CONSTRUCTOR->>
    public CriteriaBuilder(String type) {
        this.type = type;
    }

    // <<-METHODS->>
    /**
     * Builds and returns a Criteria object based on the implementation logic.
     *
     * @return A constructed Criteria object.
     */
    public abstract E build();

    /**
     * Determines if this CriteriaBuilder can accept the given type.
     *
     * @param type The type to check against the builder's type.
     * @return {@code true} if the type is accepted, {@code false} otherwise.
     */
    public boolean accept(String type) {
        return this.type.equals(type);
    }

}
