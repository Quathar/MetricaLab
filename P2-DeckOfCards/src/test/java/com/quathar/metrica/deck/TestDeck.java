package com.quathar.metrica.deck;

import com.quathar.metrica.deck.card.Card;
import com.quathar.metrica.deck.generator.FrenchDeckGenerator;
import com.quathar.metrica.deck.generator.SpanishDeckGenerator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * <h1>Test Deck</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class TestDeck {
    
    // <<-CONSTANTS->>
    private static int FRENCH_TOTAL;
    private static int SPANISH_TOTAL;

    // <<-FIELDS->>
    private Deck frenchDeck;
    private Deck spanishDeck;

    // <<-METHODS->>
    @BeforeAll
    static void setDeckSizes() {
        FRENCH_TOTAL  = DeckType.CLASSIC_FRENCH .getSuitSize() * DeckType.CLASSIC_FRENCH .getSuits().length;
        SPANISH_TOTAL = DeckType.CLASSIC_SPANISH.getSuitSize() * DeckType.CLASSIC_SPANISH.getSuits().length;
    }

    @BeforeEach
    void setUp() {
        this.frenchDeck  = new DeckImpl(new FrenchDeckGenerator());
        this.spanishDeck = new DeckImpl(new SpanishDeckGenerator());
    }
    
    @Test
    @Tag("DeckTest")
    void testCreation() {
        Card card = new Card("Diamonds", 1);
        assertEquals(card, this.frenchDeck.deal());
        this.frenchDeck.deal(11);
        assertEquals(new Card("Diamonds", 13), this.frenchDeck.deal());
        
        assertEquals(card, new Card("Diamonds", 1));
        assertNotEquals(card, null);
        assertNotEquals(card, "1 Spades");
        assertNotEquals(new Card("Spades",   1), new Card("Spades", 2));
        assertNotEquals(new Card("Diamonds", 1), new Card("Spades", 1));
    }
    
    @Test
    @Tag("DeckTest")
    void testDealingCards() {
        this.frenchDeck.deal(FRENCH_TOTAL);
        assertEquals(null, this.frenchDeck.deal());
        assertEquals(null, this.frenchDeck.deal(2));

        this.frenchDeck.shuffleAll();
        this.frenchDeck.deal(FRENCH_TOTAL - 1);
        List<Card> lastCard = new LinkedList<>(this.frenchDeck.getRemainCards());
        assertEquals(1, lastCard.size());
        assertEquals(lastCard, this.frenchDeck.deal(100));
    }
    
    @Test
    @Tag("DeckTest")
    void testSize() {
        assertEquals(FRENCH_TOTAL, this.frenchDeck.remainCardsSize());
        this.frenchDeck.deal();
        assertEquals(FRENCH_TOTAL - 1, this.frenchDeck.remainCardsSize());
        this.frenchDeck.deal(6);
        assertEquals(FRENCH_TOTAL - 7, this.frenchDeck.remainCardsSize());
        
        assertEquals(SPANISH_TOTAL, this.spanishDeck.remainCardsSize());
        this.spanishDeck.deal();
        assertEquals(SPANISH_TOTAL - 1, this.spanishDeck.remainCardsSize());
        this.spanishDeck.deal(6);
        assertEquals(SPANISH_TOTAL - 7, this.spanishDeck.remainCardsSize());
    }
    
    @Test
    @Tag("DeckTest")
    void testCardsThatCameOut() {
        Card singleCard = this.frenchDeck.deal();
        assertEquals(true, this.frenchDeck.hasComeOut(singleCard));
        assertEquals(List.of(singleCard), this.frenchDeck.getDrawnCards());
        assertEquals(1, this.frenchDeck.drawnCardsSize());

        this.frenchDeck.deal(6)
            .forEach(card -> assertEquals(true, this.frenchDeck.hasComeOut(card)));
        
        Card customCard = new Card("Pokemon", 300);
        assertEquals(false, frenchDeck.hasComeOut(customCard));
    }
    
    @Test
    @Tag("DeckTest")
    void testShuffle() {
        this.frenchDeck.deal(6);
        
        List<Card> cardsB4Shuffling = new LinkedList<>(this.frenchDeck.getRemainCards());
        assertEquals(cardsB4Shuffling, this.frenchDeck.getRemainCards());
        this.frenchDeck.shuffleRemainCards();
        assertNotEquals(cardsB4Shuffling, this.frenchDeck.getRemainCards());

        assertNotEquals(FRENCH_TOTAL, this.frenchDeck.remainCardsSize());
        this.frenchDeck.shuffleAll();
        assertEquals(FRENCH_TOTAL, this.frenchDeck.remainCardsSize());

        this.frenchDeck.deal(FRENCH_TOTAL - 1);
        
        cardsB4Shuffling = new LinkedList<>(this.frenchDeck.getRemainCards());
        assertEquals(cardsB4Shuffling, this.frenchDeck.getRemainCards());
        this.frenchDeck.shuffleRemainCards();
        // Cause there is only 1 card left on the deck assertEquals
        assertEquals(cardsB4Shuffling, this.frenchDeck.getRemainCards());
    }

}
