package com.quathar.metrica.criteria.factory;

import com.quathar.metrica.criteria.CriteriaNotNullList;

/**
 * <h1>Not Null List Builder</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class NotNullListBuilder extends CriteriaBuilder<CriteriaNotNullList> {

    // <<-CONSTRUCTOR->>
    public NotNullListBuilder() {
        super("NotNullList");
    }

    // <<-METHOD->>
    @Override
    public CriteriaNotNullList build() {
        return new CriteriaNotNullList();
    }

}
