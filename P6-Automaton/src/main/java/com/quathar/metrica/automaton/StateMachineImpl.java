package com.quathar.metrica.automaton;

/**
 * <h1>State Machine Implementation</h1>
 * <br>
 * <p>
 *     Represents an implementation of a state machine processing a sequence of transitions.
 * </p>
 *
 * @param <T> The type of transitions processed by the state machine.
 *
 * @since 2023-12-11
 * @version 1.0
 * @author DP, Q
 */
public class StateMachineImpl<T> implements StateMachine<T> {

    // <<-FIELDS->>
    private State<T> actual;

    // <<-CONSTRUCTOR->>
    public StateMachineImpl(State<T> init) {
        this.actual = init;
    }

    // <<-METHOD->>
    private void makeTransition(T transition) {
        this.actual = this.actual.transition(transition);
    }

    @Override
    public boolean accept(java.util.List<T> sequence) {
        sequence.forEach(this::makeTransition);
        return this.actual.isFinal();
    }

}
