package com.quathar.metrica.calculator;

import com.quathar.metrica.calculator.builder.AddCommandBuilder;
import com.quathar.metrica.calculator.builder.CommandBuilder;
import com.quathar.metrica.calculator.builder.CommandBuilderImpl;
import com.quathar.metrica.calculator.builder.DivideCommandBuilder;
import com.quathar.metrica.calculator.builder.MultiplyCommandBuilder;
import com.quathar.metrica.calculator.builder.SetCommandBuilder;
import com.quathar.metrica.calculator.builder.SubtractCommandBuilder;
import com.quathar.metrica.calculator.builder.UndoCommandBuilder;
import com.quathar.metrica.calculator.command.Command;

import java.util.Map;

/**
 * <h1>Command Parser</h1>
 * <br>
 * <p>
 *     Parses command lines into executable commands.
 * </p>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public abstract class CommandParser {

    // <<-CONSTANT->>
    /**
     * Map of command builders for various supported actions.
     */
    private static final Map<String, CommandBuilderImpl> BUILDERS = Map.of(
            "ADD",      new AddCommandBuilder(),
            "SUBTRACT", new SubtractCommandBuilder(),
            "MULTIPLY", new MultiplyCommandBuilder(),
            "DIVIDE",   new DivideCommandBuilder(),
            "SET",      new SetCommandBuilder(),
            "UNDO",     new UndoCommandBuilder()
    );

    // <<-METHOD->>
    /**
     * Parses a command line and returns the corresponding Command object.
     *
     * @param commandLine The string representing the command line to parse.
     * @return The Command object created from the parsed command line.
     */
    public static Command parse(String commandLine) {
        if (commandLine == null) {
            return null;
        }

        String[] operands = commandLine.toUpperCase().split(" ");
        return switch (operands.length) {
            case 1 -> {
                String action = operands[0];
                if (action.equals("UNDO"))
                     yield BUILDERS.get(action.toUpperCase()).build();
                else yield null;
            }
            case 2 -> {
                // commandLine has to be like "1 add" ["number verb"]
                // ADDITION: Could also be the other way around ["verb number"] (NOT DONE)
                String number = operands[0];
                String action = operands[1];

                CommandBuilder commandBuilder = BUILDERS.get(action);
                if (commandBuilder != null)
                     yield commandBuilder.setNumber(new java.math.BigInteger(number)).build();
                else yield null;
            }
            default -> null;
        };
    }

}
