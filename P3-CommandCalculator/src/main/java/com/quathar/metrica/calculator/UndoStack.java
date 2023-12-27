package com.quathar.metrica.calculator;

import com.quathar.metrica.calculator.command.Command;

import java.util.Stack;

/**
 * <h1>Undo Stack</h1>
 * <br>
 * <p>
 *     Represents a stack-based undo mechanism for executed commands.
 * </p>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class UndoStack {

    // <<-FIELDS->>
    private final Stack<Command> history;

    // <<-CONSTRUCTOR->>
    public UndoStack() {
        this.history = new Stack<>();
    }

    // <<-METHODS->>
    /**
     * Adds an executed command to the undo stack.
     *
     * @param executedCommand The command that was executed and needs to be stored for potential undo.
     */
    public void add(Command executedCommand) {
        this.history.add(executedCommand);
    }

    /**
     * Undo the most recent command by removing it from the stack and executing its undo operation.
     * If the history stack is empty, no action is taken.
     */
    public void undo() {
        if (!this.history.isEmpty())
            this.history.pop().undo();
    }

}
