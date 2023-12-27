package com.quathar.metrica.calculator.builder;

import com.quathar.metrica.calculator.command.operation.UndoCommand;

/**
 * <h1>UNDO Command Builder</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class UndoCommandBuilder extends CommandBuilderImpl {

    // <<-CONSTRUCTOR->>
    public UndoCommandBuilder() {
        super("UNDO");
    }

    // <<-METHOD->>
    @Override
    public UndoCommand build() {
        return new UndoCommand();
    }

}
