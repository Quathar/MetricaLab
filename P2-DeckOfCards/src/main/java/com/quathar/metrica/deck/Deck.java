package com.quathar.metrica.deck;

import com.quathar.metrica.deck.card.Card;

import java.util.List;

/**
 * <h1>Deck</h1>
 * <br>
 * <p>
 *     Represents a deck of cards.
 * </p>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public interface Deck {

    /**
     * Shuffles all cards in the deck.
     */
    void shuffleAll();

    /**
     * Shuffles only the remaining cards in the deck.
     */
    void shuffleRemainCards();

    /**
     * Deals a single card from the deck.
     *
     * @return The dealt card.
     */
    Card deal();

    /**
     * Deals a specified number of cards from the deck.
     *
     * @param amount The number of cards to deal.
     * @return A list of dealt cards.
     */
    List<Card> deal(final int amount);

    /**
     * Checks if a specific card has already been drawn.
     *
     * @param card The card to check.
     * @return {@code true} if the card has already been drawn, {@code false} otherwise.
     */
    boolean hasComeOut(final Card card);

    /**
     * Retrieves the list of remaining cards in the deck.
     *
     * @return The list of remaining cards.
     */
    List<Card> getRemainCards();

    /**
     * Retrieves the list of drawn cards from the deck.
     *
     * @return The list of drawn cards.
     */
    List<Card> getDrawnCards();

    /**
     * Retrieves the number of remaining cards in the deck.
     *
     * @return The size of the remaining cards.
     */
    int remainCardsSize();

    /**
     * Retrieves the number of drawn cards from the deck.
     *
     * @return The size of the drawn cards.
     */
    int drawnCardsSize();

}
