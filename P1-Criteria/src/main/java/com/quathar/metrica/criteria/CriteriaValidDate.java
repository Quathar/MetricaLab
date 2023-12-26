package com.quathar.metrica.criteria;

/**
 * <h1>Valid Date Criteria</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class CriteriaValidDate extends Criteria<String> {

    // <<-CONSTRUCTOR->>
    public CriteriaValidDate() {
        this.type = "ValidDate";
    }

    // <<-METHOD->>
    @Override
    public boolean comply(String value) {
        return java.util.regex.Pattern.compile("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")
                .matcher(value)
                .matches();
    }

}
