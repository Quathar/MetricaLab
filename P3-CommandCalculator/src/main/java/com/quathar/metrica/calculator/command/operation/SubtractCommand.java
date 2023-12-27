package com.quathar.metrica.calculator.command.operation;

import com.quathar.metrica.calculator.UndoStack;
import com.quathar.metrica.calculator.command.CommandImpl;
import com.quathar.metrica.calculator.model.Calculator;

/**
 * <h1>SUBTRACT Command</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class SubtractCommand extends CommandImpl {

    // <<-CONSTRUCTOR->>
    public SubtractCommand(java.math.BigInteger number) {
        super(number);
    }

    // <<-METHODS->>
    @Override
    public void execute(UndoStack history) {
        super.execute(history);
        Calculator.getInstance().subtract(this.number);
    }

}
