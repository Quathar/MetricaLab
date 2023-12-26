package com.quathar.metrica.criteria.factory;

import com.quathar.metrica.criteria.CriteriaValidDate;

/**
 * <h1>Valid Date Builder</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class ValidDateBuilder extends CriteriaBuilder<CriteriaValidDate> {

    // <<-CONSTRUCTOR->>
    public ValidDateBuilder() {
        super("ValidDate");
    }

    // <<-METHOD->>
    @Override
    public CriteriaValidDate build() {
        return new CriteriaValidDate();
    }

}
