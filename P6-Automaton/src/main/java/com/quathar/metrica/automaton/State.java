package com.quathar.metrica.automaton;

/**
 * <h1>State</h1>
 * <br>
 * <p>
 *     Represents a state in a finite state machine.
 * </p>
 *
 * @param <T> The type of transition associated with the state.
 *
 * @since 2023-12-11
 * @version 1.0
 * @author DP, Q
 */
public interface State<T> {

    /**
     *
     * Returns the new state that is the next
     * to the actual based on the transition suplied
     *
     * @param transition The transition feeds the actual state
     * @return The new State or the initial state if the transition is not acepted
     */
    State<T> transition(T transition);

    /**
     * Adds a transition to a target state.
     *
     * @param transition The transition associated with the state change.
     * @param target     The target state to which the transition leads.
     */
    void addTransition(T transition, State<T> target);

    /**
     * Checks if the state is a final state.
     *
     * @return True if the state is a final state, false otherwise.
     */
    boolean isFinal();

}
