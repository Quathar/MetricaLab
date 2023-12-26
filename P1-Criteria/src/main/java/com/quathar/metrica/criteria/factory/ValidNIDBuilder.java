package com.quathar.metrica.criteria.factory;

import com.quathar.metrica.criteria.CriteriaValidNID;

/**
 * <h1>Valid NID Builder</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class ValidNIDBuilder extends CriteriaBuilder<CriteriaValidNID> {

    // <<-CONSTRUCTOR->>
    public ValidNIDBuilder() {
        super("ValidNID");
    }

    // <<-METHOD->>
    @Override
    public CriteriaValidNID build() {
        return new CriteriaValidNID();
    }

}
