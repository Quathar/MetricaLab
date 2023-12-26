package com.quathar.metrica.criteria.factory;

import com.quathar.metrica.criteria.CriteriaValueNotRepeated;

/**
 * <h1>Value Not Repeated Builder</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class ValueNotRepeatedBuilder extends CriteriaBuilder<CriteriaValueNotRepeated> {

    // <<-CONSTRUCTOR->>
    public ValueNotRepeatedBuilder() {
        super("ValueNotRepeated");
    }

    // <<-METHOD->>
    @Override
    public CriteriaValueNotRepeated build() {
        return new CriteriaValueNotRepeated();
    }

}
