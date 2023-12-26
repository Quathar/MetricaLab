package com.quathar.metrica.criteria;

import java.util.List;

/**
 * <h1>Multiple Criteria</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class MultipleCriteria extends Criteria<Object> {

    // <<-FIELD->>
    private List<Criteria<Object>> criteriaList;

    // <<-CONSTRUCTOR->>
    public MultipleCriteria() {
    }

    // <<-METHODS->>
    @Override
    public boolean comply(Object object) {
        for (Criteria<Object> criteria : this.criteriaList)
            if (!criteria.comply(object))
                return false;
        return true;
    }
    
    public void setCriteria(List<Criteria<Object>> criteriaList) {
        this.criteriaList = criteriaList;
    }
    
}
