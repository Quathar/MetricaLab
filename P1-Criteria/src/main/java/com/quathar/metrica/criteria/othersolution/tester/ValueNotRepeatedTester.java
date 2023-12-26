package com.quathar.metrica.criteria.othersolution.tester;

/**
 * <h1>Value Not Repeated Tester</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class ValueNotRepeatedTester implements Tester<Object> {

    // <<-FIELD->>
    private java.util.Set<Object> memory;

    // <<-CONSTRUCTOR->>
    public ValueNotRepeatedTester() {
        this.memory = new java.util.HashSet<>();
    }

    // <<-METHOD->>
    @Override
    public boolean test(Object value) {
        return this.memory.add(value);
    }

}
