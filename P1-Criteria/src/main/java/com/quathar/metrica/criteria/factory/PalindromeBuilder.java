package com.quathar.metrica.criteria.factory;

import com.quathar.metrica.criteria.CriteriaPalindrome;

/**
 * <h1>Palindrome Builder</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class PalindromeBuilder extends CriteriaBuilder<CriteriaPalindrome> {

    // <<-CONSTRUCTOR->>
    public PalindromeBuilder() {
        super("Palindrome");
    }

    // <<-METHOD->>
    @Override
    public CriteriaPalindrome build() {
        return new CriteriaPalindrome();
    }

}
