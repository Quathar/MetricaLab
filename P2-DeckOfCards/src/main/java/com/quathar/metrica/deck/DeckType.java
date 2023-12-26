package com.quathar.metrica.deck;

/**
 * <h1>Deck Type</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public enum DeckType {

    // <<-CONSTANTS->>
    CLASSIC_FRENCH(13, "Diamonds", "Spades", "Hearts", "Clubs"),
    CLASSIC_SPANISH(10, "Espadas", "Copas", "Bastos", "Oros");

    // <<-FIELDS->>
    private final int size;
    private final String[] suits;

    // <<-CONSTRUCTOR->>
    DeckType(int size, String... suits) {
        this.size  = size;
        this.suits = suits;
    }

    // <<-METHODS->>
    public int getSuitSize() {
        return this.size;
    }

    public String[] getSuits() {
        return this.suits;
    }

}
