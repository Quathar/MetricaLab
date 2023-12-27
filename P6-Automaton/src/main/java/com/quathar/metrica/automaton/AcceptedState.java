package com.quathar.metrica.automaton;

/**
 * <h1>Accepted State</h1>
 * <br>
 * <p>
 *     Represents a state indicating the acceptance of a sequence in a finite state machine.
 * </p>
 *
 * @param <T> The type of transitions associated with the state.
 *
 * @since 2023-12-11
 * @version 1.0
 * @author DP, Q
 */
public class AcceptedState<T> extends StateImpl<T> {

    // <<-CONSTRUCTOR->>
    public AcceptedState(String name, State<T> defaultState) {
        super(name, defaultState);
    }

    // <<-METHOD->>
    @Override
    public boolean isFinal() {
        return true;
    }

}
