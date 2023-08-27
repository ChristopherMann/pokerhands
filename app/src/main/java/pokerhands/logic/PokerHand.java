package pokerhands.logic;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public record PokerHand(
        PokerHandType handType,
        List<CardValueOccurrence> occurrences
) implements Comparable<PokerHand> {

    @Override
    public int compareTo(PokerHand otherHand) {
        int handTypeComparison = this.handType.compareTo(otherHand.handType);

        if (handTypeComparison != 0) {
            return handTypeComparison;
        }

        for (int i = 0; i < Math.min(this.occurrences.size(), otherHand.occurrences.size()); i++) {
            var occurrence = this.occurrences.get(i);
            var otherOccurrence = otherHand.occurrences.get(i);

            int occurrencesComparison = Integer.compare(
                    occurrence.occurrences(),
                    otherOccurrence.occurrences());
            if (occurrencesComparison != 0) {
                return occurrencesComparison;
            }

            int valueComparison = Integer.compare(
                    occurrence.cardValue().ordinal(),
                    otherOccurrence.cardValue().ordinal());
            if (valueComparison != 0){
                return valueComparison;
            }
        }

        return 0;
    }
}
