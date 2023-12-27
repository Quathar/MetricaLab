package com.quathar.metrica.calculator.command.operation;

import com.quathar.metrica.calculator.UndoStack;
import com.quathar.metrica.calculator.command.UnundoableCommandImpl;

/**
 * <h1>UNDO Command</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class UndoCommand extends UnundoableCommandImpl {

    @Override
    public void execute(UndoStack history) {
        history.undo();
    }

}
