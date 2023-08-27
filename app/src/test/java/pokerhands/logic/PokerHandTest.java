package pokerhands.logic;

import org.junit.jupiter.api.Test;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;
import static pokerhands.logic.CardSuit.*;
import static pokerhands.logic.CardValue.*;
import static pokerhands.logic.PokerHandType.*;

class PokerHandTest {

    @Test
    void compareTo_FirstHandTypeIsBetter_FirstHandWins() {
        var hand = new PokerHand(TWO_PAIRS, Collections.emptyList());
        var otherHand = new PokerHand(PAIR, Collections.emptyList());

        assertThat(hand.compareTo(otherHand)).isGreaterThan(0);
    }

    @Test
    void compareTo_SecondHandTypeIsBetter_SecondHandWins() {
        var hand = new PokerHand(TWO_PAIRS, Collections.emptyList());
        var otherHand = new PokerHand(FULL_HOUSE, Collections.emptyList());

        assertThat(hand.compareTo(otherHand)).isLessThan(0);
    }
}