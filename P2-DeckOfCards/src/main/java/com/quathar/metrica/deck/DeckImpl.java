package com.quathar.metrica.deck;

import com.quathar.metrica.deck.card.Card;
import com.quathar.metrica.deck.generator.DeckGenerator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>Deck Implementation</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class DeckImpl implements Deck {

    // <<-FIELDS->>
    private final List<Card> remainCards;
    private final List<Card> drawnCards;

    // <<-CONSTRUCTOR->>
    public DeckImpl(final DeckGenerator deckGenerator) {
        this.remainCards = new LinkedList<>();
        this.drawnCards  = new LinkedList<>();
        deckGenerator.generate().forEachRemaining(this.remainCards::add);
    }

    // <<-METHODS->>
    @Override
    public void shuffleAll() {
        this.remainCards.addAll(this.drawnCards);
        Collections.shuffle(this.remainCards);
    }

    @Override
    public void shuffleRemainCards() {
        if (this.remainCards.size() > 1)
            Collections.shuffle(this.remainCards);
    }

    @Override
    public Card deal() {
        if (this.remainCards.isEmpty())
            return null;
        Card current = this.remainCards.remove(0);
        this.drawnCards.add(current);
        return current.copy();
    }

    @Override
    public List<Card> deal(final int amount) {
        if (this.remainCards.isEmpty())
            return null;
        return java.util.stream.IntStream.iterate(0, n -> n + 1)
                .limit(Math.min(amount, this.remainCards.size()))
                .mapToObj(n -> this.deal())
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public boolean hasComeOut(final Card card) {
        return this.drawnCards.contains(card);
    }

    @Override
    public List<Card> getRemainCards() {
        // Return a copy of the deck and its elements
        return this.remainCards.stream()
                .map(Card::copy)
                .toList();
    }

    @Override
    public List<Card> getDrawnCards() {
        // Return a copy of the deck and its elements
        return this.drawnCards.stream()
                .map(Card::copy)
                .toList();
    }

    @Override
    public int remainCardsSize() {
        return this.remainCards.size();
    }

    @Override
    public int drawnCardsSize() {
        return this.drawnCards.size();
    }

}
