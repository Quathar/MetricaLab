package com.quathar.metrica.calculator.builder;

import com.quathar.metrica.calculator.command.operation.MultiplyCommand;

/**
 * <h1>MULTIPLY Command Builder</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class MultiplyCommandBuilder extends CommandBuilderImpl {

    // <<-CONSTRUCTOR->>
    public MultiplyCommandBuilder() {
        super("MULTIPLY");
    }

    // <<-METHOD->>
    @Override
    public MultiplyCommand build() {
        return new MultiplyCommand(this.number);
    }

}
