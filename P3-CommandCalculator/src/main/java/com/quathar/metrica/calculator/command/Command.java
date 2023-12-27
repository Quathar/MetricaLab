package com.quathar.metrica.calculator.command;

import com.quathar.metrica.calculator.UndoStack;

/**
 * <h1>Command</h1>
 * <br>
 * <p>
 *     Represents an executable action that can be executed and undone.
 *     Implementations of this interface should provide logic for both execution and undoing of an action.
 * </p>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public interface Command {

    /**
     * Executes the defined action.
     * This method performs the action associated with this command.
     *
     * @param history The UndoStack to which this command's execution is applied.
     */
    void execute(UndoStack history);

    /**
     * Undoes the action performed by execute().
     * This method reverts the action associated with this command.
     * It should return the system to the state before the execute() method was called.
     */
    void undo();

}
