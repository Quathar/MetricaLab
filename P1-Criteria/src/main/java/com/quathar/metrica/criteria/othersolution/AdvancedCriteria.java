package com.quathar.metrica.criteria.othersolution;

import com.quathar.metrica.criteria.othersolution.tester.Tester;
import com.quathar.metrica.criteria.othersolution.tester.ValueNotRepeatedTester;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * <h1>Advanced Criteria</h1>
 * <br>
 * <p>
 *     This class provides advanced criteria testing functionalities for various data types.
 * </p>
 *
 * @param <E> The type of value to be tested.
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
public class AdvancedCriteria<E> {

	// <<-CONSTANT->>
	private static final java.util.Map<String, Tester<?>> dependencies = new java.util.HashMap<>() {
		{
			put("Palindrome", (Tester<String>)
					(word -> word != null && word.contentEquals(new StringBuilder(word).reverse())));
			put("NotNullList", (Tester<java.util.List<?>>)
					(list -> list != null && list.stream().anyMatch(Objects::isNull)));
			put("EvenNumber", (Tester<Integer>)
					(num -> num != null && num % 2 == 0));
			put("ValueNotRepeated", new ValueNotRepeatedTester());
			put("ValidNID", (Tester<String>)
					(nid -> Pattern.compile("^[0-9]{8}[A-Z]$")
							.matcher(nid)
							.matches()));
			put("ValidLicensePlate", (Tester<String>)
					(licensePlate -> Pattern.compile("^[0-9]{4} [A-Z]{3}$")
							.matcher(licensePlate)
							.matches()));
			put("ValidDate", (Tester<String>)
					(date -> Pattern.compile("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")
							.matcher(date)
							.matches()));
		}
	};

	// <<-FIELD->>
	private final Tester<E> tester;

	// <<-CONSTRUCTOR->>
	private AdvancedCriteria(String type) {
		this.tester = (Tester<E>) dependencies.get(type);
	}
	
	// <<-METHODS->>
	/**
	 * Retrieves an AdvancedCriteria object based on the given type.
	 *
	 * @param type The type associated with the AdvancedCriteria object to retrieve.
	 * @return An AdvancedCriteria object based on the given type.
	 * @param <E> The type of value to be tested.
	 * @throws IllegalArgumentException if the given type is not valid.
	 */
	public static <E> AdvancedCriteria<E> get(String type) {
		if(!dependencies.containsKey(type))
			throw new IllegalArgumentException("The type is NOT VALID");
		return new AdvancedCriteria<>(type);
	}

	/**
	 * Checks if the provided value complies with the advanced criteria.
	 *
	 * @param value The value to be tested.
	 * @return {@code true} if the value complies with the criteria, {@code false} otherwise.
	 */
	public boolean comply(E value) {
		return this.tester.test(value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.tester);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (this.getClass() != obj.getClass())
			return false;
		AdvancedCriteria other = (AdvancedCriteria) obj;
		return Objects.equals(this.tester, other.tester);
	}
	
    @Override
    public String toString() {
        return this.getClass().getName();
    }
	
}
