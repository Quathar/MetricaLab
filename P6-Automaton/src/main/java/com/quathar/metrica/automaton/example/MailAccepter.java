package com.quathar.metrica.automaton.example;

import com.quathar.metrica.automaton.AcceptedState;
import com.quathar.metrica.automaton.State;
import com.quathar.metrica.automaton.StateImpl;
import com.quathar.metrica.automaton.StateMachineImpl;

/**
 * <h1>Mail Accepter</h1>
 *
 * @since 2023-12-11
 * @version 1.0
 * @author DP, Q
 */
public class MailAccepter extends StateMachineImpl<Character> {

    // <<-CONSTANT->>
    private static final java.util.List<Character> letters = new java.util.ArrayList<>();

    static {
        {
            for (char c = 'a'; c <= 'z'; c++)
                letters.add(c);
            for (char c = '0'; c <= '9'; c++)
                letters.add(c);
        }
    }

    // <<-CONSTRUCTOR->>
    public MailAccepter() {
        super(initMachine());
    }

    // <<-METHOD->>
    /**
     * Initializes and constructs a state machine for processing email addresses.
     *
     * @return The initial state of the email address processing state machine.
     */
    private static State<Character> initMachine() {
        State<Character> init = new StateImpl<>("init");

        // TLD = Top Level Domain
        State<Character> TLD3 = new AcceptedState<>("TLD3", init);

        State<Character> TLD2 = new AcceptedState<>("TLD2", init);
        letters.forEach(c -> TLD2.addTransition(c, TLD3));

        State<Character> TLD1 = new StateImpl<>("TLD1", init);
        letters.forEach(c -> TLD1.addTransition(c, TLD2));

        State<Character> TLD0 = new StateImpl<>("TLD0", init);
        letters.forEach(c -> TLD0.addTransition(c, TLD1));

        State<Character> dom = new StateImpl<>("dom", init);
        letters.forEach(c -> dom.addTransition(c, dom));
        dom.addTransition('.', TLD0);

        State<Character> dom0 = new StateImpl<>("dom0", init);
        letters.forEach(c -> dom0.addTransition(c, dom));

        State<Character> user = new StateImpl<>("user", init);
        letters.forEach(c -> user.addTransition(c, user));
        user.addTransition('@', dom);

        letters.forEach(c -> init.addTransition(c, user));

        return init;
    }

}
