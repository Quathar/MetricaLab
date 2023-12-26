package com.quathar.metrica.criteria.factory;

import com.quathar.metrica.criteria.CriteriaValidLicensePlate;

/**
 * <h1>Valid License Plate Builder</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class ValidLicensePlateBuilder extends CriteriaBuilder<CriteriaValidLicensePlate> {

    // <<-CONSTRUCTOR->>
    public ValidLicensePlateBuilder() {
        super("ValidLicensePlate");
    }

    // <<-METHOD->>
    @Override
    public CriteriaValidLicensePlate build() {
        return new CriteriaValidLicensePlate();
    }

}
