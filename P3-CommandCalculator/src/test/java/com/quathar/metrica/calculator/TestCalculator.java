package com.quathar.metrica.calculator;

import com.quathar.metrica.calculator.command.CommandImpl;
import com.quathar.metrica.calculator.command.operation.*;
import com.quathar.metrica.calculator.model.Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <h1>Calculator Tests</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
class TestCalculator {

    // <<-FIELDS->>
    private final UndoStack history = new UndoStack();

    // <<-METHODS->>
    @BeforeEach
    void resetSingletonValue() {
        Calculator.getInstance().setValue(BigInteger.valueOf(0L));
    }
    
    @Test
    @Tag("CommandTest")
    void testSetCommand() {
        new SetCommand(BigInteger.valueOf(3L)).execute(this.history);
        assertEquals("3", Calculator.getInstance().getValue().toString());
        
        new SetCommand(BigInteger.valueOf(2L)).execute(this.history);
        assertEquals("2", Calculator.getInstance().getValue().toString());
        
        new SetCommand(BigInteger.valueOf(5L)).execute(this.history);
        assertEquals("5", Calculator.getInstance().getValue().toString());
    }
    
    @Test
    @Tag("CommandTest")
    void testAddCommand() {
        new AddCommand(BigInteger.valueOf(3L)).execute(this.history);
        assertEquals("3", Calculator.getInstance().getValue().toString());
        
        new AddCommand(BigInteger.valueOf(2L)).execute(this.history);
        assertEquals("5", Calculator.getInstance().getValue().toString());
        
        new AddCommand(BigInteger.valueOf(5L)).execute(this.history);
        assertEquals("10", Calculator.getInstance().getValue().toString());
    }
    
    @Test
    @Tag("CommandTest")
    void testSubtractCommand() {
        new SubtractCommand(BigInteger.valueOf(3L)).execute(this.history);
        assertEquals("-3", Calculator.getInstance().getValue().toString());
        
        new SubtractCommand(BigInteger.valueOf(2L)).execute(this.history);
        assertEquals("-5", Calculator.getInstance().getValue().toString());
        
        new SubtractCommand(BigInteger.valueOf(5L)).execute(this.history);
        assertEquals("-10", Calculator.getInstance().getValue().toString());
    }
    
    @Test
    @Tag("CommandTest")
    void testMultiplyCommand() {
        Calculator.getInstance().setValue(BigInteger.ONE);
        
        new MultiplyCommand(BigInteger.valueOf(3L)).execute(this.history);
        assertEquals("3", Calculator.getInstance().getValue().toString());
        
        new MultiplyCommand(BigInteger.valueOf(2L)).execute(this.history);
        assertEquals("6", Calculator.getInstance().getValue().toString());
        
        new MultiplyCommand(BigInteger.valueOf(5L)).execute(this.history);
        assertEquals("30", Calculator.getInstance().getValue().toString());
    }
    
    @Test
    @Tag("CommandTest")
    void testDivideCommand() {
        Calculator.getInstance().setValue(BigInteger.valueOf(30L));
        
        new DivideCommand(BigInteger.valueOf(5L)).execute(this.history);
        assertEquals("6", Calculator.getInstance().getValue().toString());
        
        new DivideCommand(BigInteger.valueOf(2L)).execute(this.history);
        assertEquals("3", Calculator.getInstance().getValue().toString());
        
        new DivideCommand(BigInteger.valueOf(3L)).execute(this.history);
        assertEquals("1", Calculator.getInstance().getValue().toString());
    }
    
    @Test
    @Tag("CommandTest")
    void testDivideByZero() {
        Calculator.getInstance().setValue(BigInteger.valueOf(30L));
        assertThrows(ArithmeticException.class, () -> new DivideCommand(BigInteger.ZERO).execute(this.history));
    }
    
    @Test
    @Tag("ParserTest")
    void testParserInstances() {
        assertNull(CommandParser.parse(null));
        assertNull(CommandParser.parse("Hola"));
        assertNull(CommandParser.parse("Hola sdsds"));

        assertInstanceOf(UndoCommand.class, CommandParser.parse("undo"));
        assertInstanceOf(UndoCommand.class, CommandParser.parse("UNDO"));
        assertInstanceOf(UndoCommand.class, CommandParser.parse("undo "));
        assertNull(CommandParser.parse("a dd"));
        
        assertInstanceOf(AddCommand.class, CommandParser.parse("1 add"));
        assertInstanceOf(AddCommand.class, CommandParser.parse("1 ADD"));
        assertInstanceOf(AddCommand.class, CommandParser.parse("1 add "));
        assertNull(CommandParser.parse("add"));
        assertNull(CommandParser.parse("1 ad d"));
        
        assertInstanceOf(SubtractCommand.class, CommandParser.parse("1 subtract"));
        assertInstanceOf(SubtractCommand.class, CommandParser.parse("1 SUBTRACT"));
        assertInstanceOf(SubtractCommand.class, CommandParser.parse("1 subtract "));
        assertNull(CommandParser.parse("subtract"));
        assertNull(CommandParser.parse("1 sub tract"));
        
        assertInstanceOf(MultiplyCommand.class, CommandParser.parse("1 multiply"));
        assertInstanceOf(MultiplyCommand.class, CommandParser.parse("1 MULTIPLY"));
        assertInstanceOf(MultiplyCommand.class, CommandParser.parse("1 multiply "));
        assertInstanceOf(CommandImpl.class, CommandParser.parse("1 multiply "));
        assertNull(CommandParser.parse("multiply"));
        assertNull(CommandParser.parse("1 mult iply"));
        
        assertInstanceOf(DivideCommand.class, CommandParser.parse("1 divide"));
        assertInstanceOf(DivideCommand.class, CommandParser.parse("1 DIVIDE"));
        assertInstanceOf(DivideCommand.class, CommandParser.parse("1 divide "));
        assertNull(CommandParser.parse("divide"));
        assertNull(CommandParser.parse("1 div ide"));
        
        assertInstanceOf(SetCommand.class, CommandParser.parse("1 set"));
        assertInstanceOf(SetCommand.class, CommandParser.parse("1 SET"));
        assertInstanceOf(SetCommand.class, CommandParser.parse("1 set "));
        assertNull(CommandParser.parse("set"));
        assertNull(CommandParser.parse("1 s et"));
    }
    
    @Test
    @Tag("ControllerTest")
    void testControllerBasicOperations() {
        assertEquals("12", CommandController.batchExecute("10", "2 add"));
        assertEquals("8",  CommandController.batchExecute("10", "2 subtract"));
        assertEquals("20", CommandController.batchExecute("10", "2 multiply"));
        assertEquals("5",  CommandController.batchExecute("10", "2 divide"));
        assertEquals("0",  CommandController.batchExecute("10", "0 set"));
    }
    
    @Test
    @Tag("ControllerTest")
    void testControllerCombineOperations() {
        assertEquals("9",  CommandController.batchExecute("10", "1 add", "2 subtract"));
        assertEquals("3",  CommandController.batchExecute("10", "4 subtract", "2 divide"));
        assertEquals("19", CommandController.batchExecute("10", "2 multiply", "2 subtract", "1 add"));
        assertEquals("15", CommandController.batchExecute("10", "2 divide", "3 multiply"));
        assertEquals("10", CommandController.batchExecute("10", "20 multiply", "10 set"));
    }
    
    @Test
    @Tag("ControllerTest")
    void testControllerBasicOperationsWithUndo() {
        assertEquals("10", CommandController.batchExecute("10", "2 add", "undo"));
        assertEquals("10", CommandController.batchExecute("10", "2 subtract", "undo"));
        assertEquals("10", CommandController.batchExecute("10", "2 multiply", "undo"));
        assertEquals("10", CommandController.batchExecute("10", "2 divide", "undo"));
        assertEquals("10", CommandController.batchExecute("10", "2 set", "undo"));
        assertEquals("2", CommandController.batchExecute("10", "undo", "2 set", "undo", "undo", "2 set", "2 add", "undo"));
    }
    
}
