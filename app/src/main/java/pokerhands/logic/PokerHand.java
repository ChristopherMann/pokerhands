package pokerhands.logic;

import java.util.Comparator;
import java.util.List;

public record PokerHand(
        PokerHandType handType,
        List<CardValueOccurrence> occurrences
) implements Comparable<PokerHand> {

    @Override
    public int compareTo(PokerHand otherHand) {
        return 0;
    }
}
