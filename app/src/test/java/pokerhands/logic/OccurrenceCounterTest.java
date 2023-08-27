package pokerhands.logic;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static pokerhands.logic.CardSuit.*;
import static pokerhands.logic.CardValue.*;

class OccurrenceCounterTest {
    private final OccurrenceCounter occurrenceCounter = new OccurrenceCounter();

    @Test
    void countOccurences_DifferentNumberOfOccurrences_AreSortedByOccurence() {
        var cards = List.of(
            new Card(CLUBS, TWO),
            new Card(CLUBS, THREE),
            new Card(SPADES, TWO),
            new Card(DIAMONDS, TWO),
            new Card(SPADES, THREE)
        );

        var occurrences = occurrenceCounter.countOccurences(cards);

        assertThat(occurrences).usingRecursiveComparison().isEqualTo(
            List.of(new CardValueOccurrence(TWO, 3),
                    new CardValueOccurrence(THREE, 2)
            )
        );
    }

    @Test
    void countOccurences_SameNumberOfOccurrences_AreSortedByCardValue() {
        var cards = List.of(
                new Card(CLUBS, TWO),
                new Card(CLUBS, THREE),
                new Card(SPADES, TWO),
                new Card(DIAMONDS, KING),
                new Card(SPADES, THREE)
        );

        var occurrences = occurrenceCounter.countOccurences(cards);

        assertThat(occurrences).usingRecursiveComparison().isEqualTo(
                List.of(new CardValueOccurrence(THREE, 2),
                        new CardValueOccurrence(TWO, 2),
                        new CardValueOccurrence(KING, 1)
                )
        );
    }

    @Test
    void countOccurences_MultipleCardsWithLowOccurrence_AreSortedByCardValue() {
        var cards = List.of(
                new Card(CLUBS, TWO),
                new Card(CLUBS, THREE),
                new Card(SPADES, TWO),
                new Card(DIAMONDS, KING),
                new Card(SPADES, FOUR)
        );

        var occurrences = occurrenceCounter.countOccurences(cards);

        assertThat(occurrences).usingRecursiveComparison().isEqualTo(
                List.of(new CardValueOccurrence(TWO, 2),
                        new CardValueOccurrence(KING, 1),
                        new CardValueOccurrence(FOUR, 1),
                        new CardValueOccurrence(THREE, 1)
                )
        );
    }
}