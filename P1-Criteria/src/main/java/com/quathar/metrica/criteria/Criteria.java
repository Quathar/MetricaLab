package com.quathar.metrica.criteria;

import com.quathar.metrica.criteria.factory.CriteriaBuilder;
import com.quathar.metrica.criteria.factory.EvenNumberBuilder;
import com.quathar.metrica.criteria.factory.NotNullListBuilder;
import com.quathar.metrica.criteria.factory.PalindromeBuilder;
import com.quathar.metrica.criteria.factory.ValidDateBuilder;
import com.quathar.metrica.criteria.factory.ValidLicensePlateBuilder;
import com.quathar.metrica.criteria.factory.ValidNIDBuilder;
import com.quathar.metrica.criteria.factory.ValueNotRepeatedBuilder;

import java.util.Objects;

/**
 * <h1>Criteria</h1>
 * <br>
 * <p>
 *     This abstract class represents criteria for evaluating certain values.
 *     Implementations should extend this class and provide logic to check if a
 *     specific value complies with the defined criteria.
 * </p>
 *
 * @param <E> The type of value this criteria evaluates.
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public abstract class Criteria<E> {

    // <<-CONSTANT->>
    private static final CriteriaBuilder<?>[] CRITERIA_BUILDERS = {
            new EvenNumberBuilder(),
            new NotNullListBuilder(),
            new PalindromeBuilder(),
            new ValidDateBuilder(),
            new ValidLicensePlateBuilder(),
            new ValidNIDBuilder(),
            new ValueNotRepeatedBuilder()
    };

    // <<-FIELD->>
    protected String type;

    // <<-CONSTRUCTOR->>
    protected Criteria() {
    }

    // <<-METHODS->>
    /**
     * Retrieves a Criteria object based on the given type.
     *
     * @param type The type associated with the Criteria object to retrieve.
     * @return A Criteria object based on the given type, or null if not found.
     */
    public static Criteria<?> get(String type) {
        return java.util.Arrays.stream(CRITERIA_BUILDERS)
                .filter(builder -> builder.accept(type))
                .map(CriteriaBuilder::build)
                .findFirst()
                .orElse(null);
    }

    /**
     * Checks if the provided value complies with the criteria.
     *
     * @param value The value to evaluate against the criteria.
     * @return {@code true} if the value complies, {@code false} otherwise.
     */
    public abstract boolean comply(E value);

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (this.getClass() != obj.getClass())
            return false;
        Criteria other = (Criteria) obj;
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
