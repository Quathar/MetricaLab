package com.quathar.metrica.calculator.command.operation;

import com.quathar.metrica.calculator.UndoStack;
import com.quathar.metrica.calculator.command.CommandImpl;
import com.quathar.metrica.calculator.model.Calculator;

import java.math.BigInteger;

/**
 * <h1>DIVIDE Command</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class DivideCommand extends CommandImpl {

    // <<-CONSTRUCTOR->>
    public DivideCommand(java.math.BigInteger number) {
        super(number);
    }

    // <<-METHOD->>
    /**
     * Executes the defined action.
     * This method performs the action associated with this command.
     *
     * @throws ArithmeticException if attempting to divide by zero.
     */
    @Override
    public void execute(UndoStack history) throws ArithmeticException {
        super.execute(history);
        Calculator.getInstance().divide(this.number);
    }

}
