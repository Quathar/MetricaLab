package com.quathar.metrica.calculator.command.operation;

import com.quathar.metrica.calculator.UndoStack;
import com.quathar.metrica.calculator.command.CommandImpl;
import com.quathar.metrica.calculator.model.Calculator;

/**
 * <h1>ADD Command</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class AddCommand extends CommandImpl {

    // <<-CONSTRUCTOR->>
    public AddCommand(java.math.BigInteger number) {
        super(number);
    }

    // <<-METHOD->>
    @Override
    public void execute(UndoStack history) {
        super.execute(history);
        Calculator.getInstance().add(this.number);
    }
    
}
