package com.quathar.metrica.automaton;

/**
 * <h1>State Machine</h1>
 * <br>
 * <p>
 *     Represents a state machine that processes a sequence of transitions.
 * </p>
 *
 * @param <T> The type of transitions in the state machine.
 *
 * @since 2023-12-11
 * @version 1.0
 * @author DP, Q
 */
public interface StateMachine<T> {

    /**
     * Processes a sequence of transitions.
     * Determines if the state machine accepts the given sequence of transitions.
     *
     * @param sequence The sequence of transitions to be processed.
     * @return True if the state machine accepts the sequence, false otherwise.
     */
    boolean accept(java.util.List<T> sequence);

}
