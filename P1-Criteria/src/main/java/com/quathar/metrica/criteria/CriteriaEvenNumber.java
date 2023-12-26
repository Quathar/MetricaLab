package com.quathar.metrica.criteria;

/**
 * <h1>Even Number Criteria</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class CriteriaEvenNumber extends Criteria<Object> {

    // <<-CONSTRUCTOR->>
    public CriteriaEvenNumber() {
        this.type = "EvenNumber";
    }

    // <<-METHOD->>
    @Override
    public boolean comply(Object value) {
        return value != null && Integer.parseInt(value.toString()) % 2 == 0;
    }

}
