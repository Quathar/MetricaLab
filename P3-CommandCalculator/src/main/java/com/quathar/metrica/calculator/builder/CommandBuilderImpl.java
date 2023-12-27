package com.quathar.metrica.calculator.builder;

import java.math.BigInteger;

/**
 * <h1>Command Builder Implementation</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public abstract class CommandBuilderImpl implements CommandBuilder {

    // <<-FIELDS->>
    private final String type;
    protected BigInteger number;

    // <<-CONSTRUCTOR->>
    public CommandBuilderImpl(String type) {
        this.type = type;
    }

    // <<-METHODS->>
    @Override
    public boolean accept(String type) {
        return type != null && type.toUpperCase()
                .trim()
                .equals(this.type);
    }

    @Override
    public CommandBuilder setNumber(BigInteger number) {
        this.number = number;
        return this;
    }
    
}
