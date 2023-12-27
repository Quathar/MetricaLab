package com.quathar.metrica.calculator.model;

import java.math.BigInteger;

/**
 * <h1>Calculator</h1>
 * <br>
 * <p>
 *     Represents a simple calculator performing arithmetic operations on a single number.
 * </p>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class Calculator implements Operable {

    // <<-FIELDS->>
    private static Calculator instance;
    private BigInteger number;
    
    // <<-CONSTRUCTOR->>
    /**
     * Private constructor to prevent direct instantiation of Calculator.
     * Use getInstance() to retrieve the Calculator instance.
     */
    private Calculator() {
    }
    
    // <<-METHODS->>
    /**
     * Retrieves the instance of the Calculator class. If the instance does not exist,
     * it creates a new instance and returns it.
     *
     * @return The instance of the Calculator class.
     */
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    @Override
    public void setValue(BigInteger number) {
        this.number = number;
    }

    @Override
    public BigInteger getValue() {
        return number;
    }

    @Override
    public void add(BigInteger number) {
        this.number = this.number.add(number);
    }

    @Override
    public void subtract(BigInteger number) {
    	this.number = this.number.subtract(number);
    }

    @Override
    public void multiply(BigInteger number) {
    	this.number = this.number.multiply(number);
    }

    @Override
    public void divide(BigInteger number) {
    	this.number = this.number.divide(number);
    }

}
