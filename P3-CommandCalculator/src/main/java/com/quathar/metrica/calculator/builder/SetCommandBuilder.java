package com.quathar.metrica.calculator.builder;

import com.quathar.metrica.calculator.command.operation.SetCommand;

/**
 * <h1>SET Command Builder</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class SetCommandBuilder extends CommandBuilderImpl {

    // <<-CONSTRUCTOR->>
    public SetCommandBuilder() {
        super("SET");
    }

    // <<-METHOD->>
    @Override
    public SetCommand build() {
        return new SetCommand(this.number);
    }

}
