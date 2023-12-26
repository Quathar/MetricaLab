package com.quathar.metrica.criteria;

/**
 * <h1>Valid License Plate Criteria</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class CriteriaValidLicensePlate extends Criteria<String> {

    // <<-CONSTRUCTOR->>
    public CriteriaValidLicensePlate() {
        this.type = "ValidLicensePlate";
    }

    // <<-METHOD->>
    @Override
    public boolean comply(String value) {
        return value != null && java.util.regex.Pattern.compile("^[0-9]{4} [A-Z]{3}$")
                .matcher(value)
                .matches();
    }

}
