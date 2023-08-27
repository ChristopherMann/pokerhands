package pokerhands.logic;

import java.util.List;

import static pokerhands.logic.PokerHandType.*;

public class PokerHandFactory {
    private  OccurrenceCounter occurrenceCounter;

    public PokerHandFactory(OccurrenceCounter occurrenceCounter) {
        this.occurrenceCounter = occurrenceCounter;
    }

    public PokerHand createPokerHand(List<Card> cards) {
        var occurrences = occurrenceCounter.countOccurences(cards);

        boolean isFlush = isFlush(cards);
        boolean isStraight = isStraight(cards);

        PokerHandType handType;
        if (isStraight && isFlush) {
            handType = STRAIGHT_FLUSH;
        } else if (isStraight) {
            handType = STRAIGHT;
        } else if (isFlush) {
            handType = FLUSH;
        } else {
            handType = HIGH_CARD;
        }

        return new PokerHand(handType, occurrences);
    }

    private boolean isFlush(List<Card> cards) {
        return cards.stream().allMatch(card -> card.suit() == cards.get(0).suit());
    }

    private boolean isStraight(List<Card> cards) {
        // TODO implement
        return false;
    }
}
