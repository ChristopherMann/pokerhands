package pokerhands.logic;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OccurrenceCounter {
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
