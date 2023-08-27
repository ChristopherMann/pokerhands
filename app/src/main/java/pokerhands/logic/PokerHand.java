package pokerhands.logic;

import java.util.Comparator;
import java.util.List;

public record PokerHand(
        PokerHandType handType,
        List<CardValueOccurrence> occurrences
) { }
