package com.quathar.metrica.automaton;

import org.junit.jupiter.api.Test;

import com.quathar.metrica.automaton.example.MailAccepter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <h1>Mail Accepter Tests</h1>
 *
 * @since 2023-12-11
 * @version 1.0
 * @author DP, Q
 */
class TestMailAccepter {

    @Test
    void test1() {
        MailAccepter machine = new MailAccepter();
        assertTrue(machine.accept("hola@metrica.es".chars()
                .mapToObj(c -> Character.valueOf((char) c))
                .toList()));
    }

    @Test
    void test2() {
        MailAccepter machine = new MailAccepter();
        assertFalse(machine.accept("hola.metrica.es".chars()
                .mapToObj(c -> Character.valueOf((char) c))
                .toList()));
    }

}
