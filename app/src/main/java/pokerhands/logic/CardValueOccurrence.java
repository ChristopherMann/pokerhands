package pokerhands.logic;

public class CardValueOccurrence {
    private CardValue cardValue;
    private int occurrences;

    public CardValueOccurrence(CardValue cardValue, int occurrences) {
        this.cardValue = cardValue;
        this.occurrences = occurrences;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public int getOccurrences() {
        return occurrences;
    }
}
