package com.quathar.metrica.automaton;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>State Implementation</h1>
 * <br>
 * <p>
 *     Represents an implementation of a state in a finite state machine.
 * </p>
 *
 * @param <T> The type of transition associated with the state.
 *
 * @since 2023-12-11
 * @version 1.0
 * @author DP, Q
 */
public class StateImpl<T> implements State<T> {

    // <<-FIELDS->>
    private String name;
    private Map<T, State<T>> transitions;
    private State<T> defaultState;

    // <<-CONSTRUCTORS->>
    public StateImpl(String name, Map<T, State<T>> transitions, State<T> defaultState) {
        this.name = name;
        this.transitions = transitions;
        this.defaultState = defaultState;
    }

    public StateImpl(String name, State<T> defaultState) {
        this(name, new HashMap<>(), defaultState);
    }

    public StateImpl(String name) {
        this(name, new HashMap<>(), null);
        this.defaultState = this;
    }

    // <<-METHODS->>
    @Override
    public State<T> transition(T transition) {
        return this.transitions.getOrDefault(transition, defaultState);
    }

    @Override
    public void addTransition(T transition, State<T> target) {
        this.transitions.put(transition, target);
    }

    @Override
    public boolean isFinal() {
        return false;
    }

}
