package com.quathar.metrica.criteria;

/**
 * <h1>Value Not Repeated Criteria</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class CriteriaValueNotRepeated extends Criteria<Object> {

    // <<-FIELD->>
    private final java.util.Set<Object> memory;

    // <<-CONSTRUCTOR->>
    public CriteriaValueNotRepeated() {
        this.type = "ValueNotRepeated";
        this.memory = new java.util.HashSet<>();
    }

    // <<-METHOD->>
    @Override
    public boolean comply(Object value) {
        return this.memory.add(value);
    }

}
