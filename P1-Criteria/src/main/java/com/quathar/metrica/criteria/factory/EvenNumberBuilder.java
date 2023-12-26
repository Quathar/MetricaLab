package com.quathar.metrica.criteria.factory;

import com.quathar.metrica.criteria.CriteriaEvenNumber;

/**
 * <h1>Even Number Builder</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class EvenNumberBuilder extends CriteriaBuilder<CriteriaEvenNumber> {

    // <<-CONSTRUCTOR->>
    public EvenNumberBuilder() {
        super("EvenNumber");
    }

    // <<-METHOD->>
    @Override
    public CriteriaEvenNumber build() {
        return new CriteriaEvenNumber();
    }

}
