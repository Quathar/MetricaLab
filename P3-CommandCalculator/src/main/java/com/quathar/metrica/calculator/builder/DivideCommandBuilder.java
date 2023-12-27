package com.quathar.metrica.calculator.builder;

import com.quathar.metrica.calculator.command.operation.DivideCommand;

/**
 * <h1>DIVIDE Command Builder</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class DivideCommandBuilder extends CommandBuilderImpl {

    // <<-CONSTRUCTOR->>
    public DivideCommandBuilder() {
        super("DIVIDE");
    }

    // <<-METHOD->>
    @Override
    public DivideCommand build() {
        return new DivideCommand(this.number);
    }

}
