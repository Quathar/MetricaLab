package com.quathar.metrica.criteria;

/**
 * <h1>Valid NID (National Identification Document) Criteria</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class CriteriaValidNID extends Criteria<String> {

    // <<-CONSTRUCTOR->>
    public CriteriaValidNID() {
        this.type = "ValidNID";
    }

    // <<-METHOD->>
    @Override
    public boolean comply(String value) {
        return java.util.regex.Pattern.compile("^[0-9]{8}[A-Z]$")
                .matcher(value)
                .matches();
    }

}
