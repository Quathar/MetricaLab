package com.quathar.metrica.calculator.command;

import java.lang.invoke.WrongMethodTypeException;

/**
 * <h1>Un-undoable Command Implementation</h1>
 * <br>
 * <p>
 *     Represents a command that cannot be undone.
 * </p>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public abstract class UnundoableCommandImpl implements Command {

    /**
     * Throws an exception as an unsupported operation for undo.
     * Subclasses of this command type cannot be undone.
     *
     * @throws WrongMethodTypeException Thrown when attempting to undo an un-undoable command.
     */
    @Override
    public void undo() {
        throw new WrongMethodTypeException();
    }

}
