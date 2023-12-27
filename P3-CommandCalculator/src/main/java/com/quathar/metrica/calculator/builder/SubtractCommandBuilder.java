package com.quathar.metrica.calculator.builder;

import com.quathar.metrica.calculator.command.operation.SubtractCommand;

/**
 * <h1>SUBTRACT Command Builder</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class SubtractCommandBuilder extends CommandBuilderImpl {

    // <<-CONSTRUCTOR->>
    public SubtractCommandBuilder() {
        super("SUBTRACT");
    }

    // <<-METHOD->>
    @Override
    public SubtractCommand build() {
        return new SubtractCommand(this.number);
    }

}
