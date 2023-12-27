package com.quathar.metrica.calculator;

import com.quathar.metrica.calculator.model.Calculator;

/**
 * <h1>Command Controller</h1>
 * <br>
 * <p>
 *     Manages the execution of multiple commands in a batch.
 * </p>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public abstract class CommandController {

    /**
     * Executes a batch of commands based on the provided value and orders.
     *
     * @param value  The initial value for the calculation.
     * @param orders The array of string orders representing commands to execute.
     * @return The resulting value after executing the batch of commands.
     */
    public static String batchExecute(String value, String... orders) {
        Calculator.getInstance().setValue(new java.math.BigInteger(value));

        UndoStack history = new UndoStack();
        java.util.Arrays.stream(orders)
                .map(CommandParser::parse)
                .filter(java.util.Objects::nonNull)
                .forEach(command -> command.execute(history));
        return Calculator.getInstance().getValue().toString();
    }
    
}
