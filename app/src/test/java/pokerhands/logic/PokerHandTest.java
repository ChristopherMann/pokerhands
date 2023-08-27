package pokerhands.logic;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static pokerhands.logic.CardValue.*;
import static pokerhands.logic.PokerHandType.*;

class PokerHandTest {
    @Test
    void compareTo_FirstHandTypeIsBetter_FirstHandWins() {
        var firstHand = new PokerHand(TWO_PAIRS, Collections.emptyList());
        var secondhand = new PokerHand(PAIR, Collections.emptyList());

        assertThat(firstHand).isGreaterThan(secondhand);
    }

    @Test
    void compareTo_SecondHandTypeIsBetter_SecondHandWins() {
        var firstHand = new PokerHand(TWO_PAIRS, Collections.emptyList());
        var secondHand = new PokerHand(FULL_HOUSE, Collections.emptyList());

        assertThat(secondHand).isGreaterThan(firstHand);
    }

    @Test
    void compareTo_SameHandTypeAndFirstHandHasHigherCard_FirstHandWins() {
        var firstHand = new PokerHand(TWO_PAIRS, List.of(
                new CardValueOccurrence(THREE, 2),
                new CardValueOccurrence(TWO, 2),
                new CardValueOccurrence(JACK, 1)));
        var secondHand = new PokerHand(TWO_PAIRS, List.of(
                new CardValueOccurrence(THREE, 2),
                new CardValueOccurrence(TWO, 2),
                new CardValueOccurrence(EIGHT, 1)));

        assertThat(firstHand).isGreaterThan(secondHand);
    }

    @Test
    void compareTo_SameHandTypeAndFirstHandHasHigherCard_SecondHandWins() {
        var firstHand = new PokerHand(TWO_PAIRS, List.of(
                new CardValueOccurrence(THREE, 2),
                new CardValueOccurrence(TWO, 2),
                new CardValueOccurrence(JACK, 1)));
        var secondHand = new PokerHand(TWO_PAIRS, List.of(
                new CardValueOccurrence(THREE, 2),
                new CardValueOccurrence(TWO, 2),
                new CardValueOccurrence(QUEEN, 1)));

        assertThat(secondHand).isGreaterThan(firstHand);
    }
}