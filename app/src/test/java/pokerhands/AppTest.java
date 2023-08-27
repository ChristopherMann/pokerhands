package pokerhands;

import org.junit.jupiter.api.Test;
import pokerhands.logic.Card;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static pokerhands.logic.CardValue.*;
import static pokerhands.logic.CardSuit.*;

class AppTest {
    @Test
    void compareHands_BothHandsWithSamePairs_HighestCardWins() {
        var firstHand = List.of(
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, TWO),
                new Card(CLUBS, THREE),
                new Card(DIAMONDS, THREE),
                new Card(CLUBS, JACK));

        var secondHand = List.of(
                new Card(HEARTS, TWO),
                new Card(SPADES, TWO),
                new Card(HEARTS, THREE),
                new Card(SPADES, THREE),
                new Card(HEARTS, TEN));

        assertThat(App.CompareHands(firstHand, secondHand))
                .isGreaterThan(0);
    }

    @Test
    void compareHands_BothHandsAreStraights_HighestCardWins() {
        var firstHand = List.of(
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, THREE),
                new Card(CLUBS, FOUR),
                new Card(DIAMONDS, FIVE),
                new Card(CLUBS, SIX));

        var secondHand = List.of(
                new Card(HEARTS, THREE),
                new Card(SPADES, FOUR),
                new Card(HEARTS, FIVE),
                new Card(SPADES, SIX),
                new Card(HEARTS, SEVEN));

        assertThat(App.CompareHands(firstHand, secondHand))
                .isLessThan(0);
    }
}