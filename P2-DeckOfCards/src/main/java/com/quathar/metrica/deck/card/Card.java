package com.quathar.metrica.deck.card;

import java.util.Objects;

/**
 * <h1>Card</h1>
 *
 * @since 2023-10-03
 * @version 1.0
 * @author Q
 */
public class Card {

    // <<-FIELDS->>
    protected int number;
    protected String suit;

    // <<-CONSTRUCTOR->>
    public Card(String suit, int number) {
        this.suit   = suit;
        this.number = number;
    }

    // <<-METHODS->>
    /**
     * Creates a copy of this Card.
     *
     * @return A new Card instance with the same suit and number.
     */
    public Card copy() {
        return new Card(this.suit, this.number);
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.number, this.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.suit, this.number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        return this.number == other.number && Objects.equals(this.suit, other.suit);
    }

}
