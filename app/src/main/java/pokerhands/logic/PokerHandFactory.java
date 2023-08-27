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
        } else if (isFourOfAKind(occurrences)) {
            handType = FOUR_OF_A_KIND;
        } else if (isFullHouse(occurrences)) {
            handType = FULL_HOUSE;
        } else if (isFlush) {
            handType = FLUSH;
        } else if (isStraight) {
            handType = STRAIGHT;
        } else if (isThreeOfAKind(occurrences)) {
            handType = THREE_OF_A_KIND;
        } else if (isTwoPairs(occurrences)) {
            handType = TWO_PAIRS;
        } else if(isPair(occurrences)){
            handType = PAIR;
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

    private boolean isFourOfAKind(List<CardValueOccurrence> occurrences) {
        return occurrences.get(0).occurrences() == 4;
    }

    private boolean isFullHouse(List<CardValueOccurrence> occurrences) {
        return occurrences.get(0).occurrences() == 3
                && occurrences.get(1).occurrences() == 2;
    }

    private boolean isThreeOfAKind(List<CardValueOccurrence> occurrences) {
        return occurrences.get(0).occurrences() == 3;
    }

    private boolean isTwoPairs(List<CardValueOccurrence> occurrences) {
        return occurrences.get(0).occurrences() == 2
                && occurrences.get(1).occurrences() == 2;
    }

    private boolean isPair(List<CardValueOccurrence> occurrences) {
        return occurrences.get(0).occurrences() == 2;
    }
}
