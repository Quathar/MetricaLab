package com.quathar.metrica.deck.generator;

/**
 * <h1>Deck Generator</h1>
 * <br>
 * <p>
 *     This interface defines a contract for generating decks of cards.
 * </p>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public interface DeckGenerator {

    /**
     * Generates a deck of cards.
     *
     * @return An iterator over the generated cards.
     */
    java.util.Iterator<com.quathar.metrica.deck.card.Card> generate();

}
