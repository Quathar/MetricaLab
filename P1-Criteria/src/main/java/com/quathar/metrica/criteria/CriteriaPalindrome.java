package com.quathar.metrica.criteria;

/**
 * <h1>Palindrome Criteria</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class CriteriaPalindrome extends Criteria<String> {

    // <<-CONSTRUCTOR->>
    public CriteriaPalindrome() {
        this.type = "Palindrome";
    }

    // <<-METHODS->>
    private boolean isPalindrome(String value) {
        int left = 0, right = value.length() - 1;

        while (left < right) {
            while (left < right && value.charAt(left) == ' ')
                left++;
            while (left < right && value.charAt(right) == ' ')
                right--;
            if (value.charAt(left) != value.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;

        // Chill... I know StringBuilder().reverse() exist
    }

    @Override
    public boolean comply(String value) {
        return value != null && isPalindrome(value);
    }

}
