package com.quathar.metrica.criteria;

import java.util.List;

/**
 * <h1>Not Null List Criteria</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class CriteriaNotNullList extends Criteria<List<?>> {

    // <<-CONSTRUCTOR->>
    public CriteriaNotNullList() {
        this.type = "NotNullList";
    }

    // <<-METHOD->>
    @Override
    public boolean comply(List<?> value) {
        return value != null && value.stream().noneMatch(java.util.Objects::isNull);
    }

}
