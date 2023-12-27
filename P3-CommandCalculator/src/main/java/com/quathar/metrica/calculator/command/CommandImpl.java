package com.quathar.metrica.calculator.command;

import com.quathar.metrica.calculator.UndoStack;
import com.quathar.metrica.calculator.model.Calculator;

import java.math.BigInteger;

/**
 * <h1>Command Implementation</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public abstract class CommandImpl implements Command {
    
    // <<-FIELD->>
    protected BigInteger number;
    private   BigInteger backup;

    // <<-CONSTRUCTOR->>
    public CommandImpl(BigInteger number) {
        this.number = number;
    }

    // <<-METHODS->>
    @Override
    public void execute(UndoStack history) {
        this.backup = Calculator.getInstance().getValue();
        history.add(this);
    }

    @Override
    public void undo() {
        Calculator.getInstance().setValue(this.backup);
    }
    
}
