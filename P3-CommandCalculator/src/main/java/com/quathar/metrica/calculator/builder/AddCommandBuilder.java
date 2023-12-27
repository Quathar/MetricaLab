package com.quathar.metrica.calculator.builder;

import com.quathar.metrica.calculator.command.operation.AddCommand;

/**
 * <h1>ADD Command Builder</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class AddCommandBuilder extends CommandBuilderImpl {

    // <<-CONSTRUCTOR->>
    public AddCommandBuilder() {
        super("ADD");
    }

    // <<-METHOD->>
    @Override
    public AddCommand build() {
        return new AddCommand(this.number);
    }
    
}
