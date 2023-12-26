package com.quathar.metrica.deck.generator;

import com.quathar.metrica.deck.DeckType;
import com.quathar.metrica.deck.card.Card;

import java.util.Iterator;

/**
 * <h1>Deck Generator Impl</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class DeckGeneratorImpl implements DeckGenerator {

    // <<-FIELD->>
    private final DeckType deckType;

    // <<-CONSTRUCTORS->>
    public DeckGeneratorImpl(DeckType deckType) {
        this.deckType = deckType;
    }

    public DeckGeneratorImpl(String type) {
        this(DeckType.valueOf(type));
    }

    // <<-METHOD->>
    @Override
    public Iterator<Card> generate() {
        return new Iterator<>() {
            // <<-FIELDS->>
            int actualSuit = 0;
            int actualNumber = 1;

            // <<-METHODS->>
            @Override
            public boolean hasNext() {
                return actualSuit < deckType.getSuits().length && actualNumber <= deckType.getSuitSize();
            }

            @Override
            public Card next() {
                Card target = new Card(deckType.getSuits()[actualSuit], actualNumber);
                actualNumber++;
                if (actualNumber > deckType.getSuitSize()) {
                    actualNumber = 1;
                    actualSuit++;
                }
                return target;
            }
        };
    }

}
