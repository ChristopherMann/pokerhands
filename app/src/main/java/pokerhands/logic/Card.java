package pokerhands.logic;

/**
 * Represents a playing card.
 */
public class Card {
    private CardSuit suit;
    private CardValue value;

    public Card(CardSuit suit1, CardValue value) {
        this.suit = suit1;
        this.value = value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }
}
