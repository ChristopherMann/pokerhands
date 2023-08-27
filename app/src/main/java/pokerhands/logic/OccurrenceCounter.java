package pokerhands.logic;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OccurrenceCounter {
    /**
     * Counts the occurrences of card values.
     * @param cards The cards for which the occurences should be counted.
     * @return The occurrences sorted in descending order by occurrences and then card value.
     */
    public List<CardValueOccurrence> countOccurences(List<Card> cards) {
        return cards.stream().collect(Collectors.groupingBy(Card::value))
            .entrySet().stream()
            .map(e -> new CardValueOccurrence(e.getKey(), e.getValue().size()))
            .sorted(Comparator.comparing(CardValueOccurrence::occurrences)
                    .thenComparing(CardValueOccurrence::cardValue)
                    .reversed())
            .toList();
    }
}
