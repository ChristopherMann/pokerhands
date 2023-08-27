package pokerhands.logic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pokerhands.logic.CardSuit.*;
import static pokerhands.logic.CardValue.*;
import static pokerhands.logic.PokerHandType.*;

class PokerHandFactoryTest {

    private final PokerHandFactory factory = new PokerHandFactory(new OccurrenceCounter());

    @Test
    void createPokerHand_CardsAreNothing_DetectsHighCard() {
        var cards = List.of(
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, FOUR),
                new Card(HEARTS, SIX),
                new Card(SPADES, EIGHT),
                new Card(CLUBS, TEN));

        var pokerHand = factory.createPokerHand(cards);

        assertEquals(pokerHand.handType(), HIGH_CARD);
    }

    @Test
    void createPokerHand_CardsAreSinglePair_DetectsPair() {
        var cards = List.of(
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, TWO),
                new Card(HEARTS, SIX),
                new Card(SPADES, EIGHT),
                new Card(CLUBS, TEN));

        var pokerHand = factory.createPokerHand(cards);

        assertEquals(pokerHand.handType(), PAIR);
    }

    @Test
    void createPokerHand_CardsAreTwoPairs_DetectsTwoPair() {
        var cards = List.of(
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, TWO),
                new Card(HEARTS, SIX),
                new Card(SPADES, SIX),
                new Card(CLUBS, TEN));

        var pokerHand = factory.createPokerHand(cards);

        assertEquals(pokerHand.handType(), TWO_PAIRS);
    }

    @Test
    void createPokerHand_CardsAreThreeOfAKind_DetectsThreeOfAKind() {
        var cards = List.of(
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, TWO),
                new Card(HEARTS, TWO),
                new Card(SPADES, SIX),
                new Card(CLUBS, TEN));

        var pokerHand = factory.createPokerHand(cards);

        assertEquals(pokerHand.handType(), THREE_OF_A_KIND);
    }

    @Test
    void createPokerHand_CardsAreAStraight_DetectsStraight() {
        var cards = List.of(
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, FIVE),
                new Card(HEARTS, THREE),
                new Card(SPADES, FOUR),
                new Card(CLUBS, SIX));


        var pokerHand = factory.createPokerHand(cards);

        assertEquals(pokerHand.handType(), STRAIGHT);
    }

    @Test
    void createPokerHand_CardsAreAFlush_DetectsFlush() {
        var cards = List.of(
                new Card(SPADES, FOUR),
                new Card(SPADES, TWO),
                new Card(SPADES, FIVE),
                new Card(SPADES, KING),
                new Card(SPADES, ACE));

        var pokerHand = factory.createPokerHand(cards);

        assertEquals(pokerHand.handType(), FLUSH);
    }

    @Test
    void createPokerHand_CardsAreFullHouse_DetectsFullHouse() {
        var cards = List.of(
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, SIX),
                new Card(HEARTS, TWO),
                new Card(SPADES, SIX),
                new Card(CLUBS, TWO));

        var pokerHand = factory.createPokerHand(cards);

        assertEquals(pokerHand.handType(), FULL_HOUSE);
    }

    @Test
    void createPokerHand_CardsAreFourOfAKind_DetectsFourOfAKind() {
        var cards = List.of(
                new Card(CLUBS, TWO),
                new Card(DIAMONDS, TWO),
                new Card(HEARTS, SIX),
                new Card(SPADES, TWO),
                new Card(CLUBS, TWO));

        var pokerHand = factory.createPokerHand(cards);

        assertEquals(pokerHand.handType(), FOUR_OF_A_KIND);
    }

    @Test
    void createPokerHand_CardsAreAStraightFlush_DetectsStraightFlush() {
        var cards = List.of(
                new Card(SPADES, TWO),
                new Card(SPADES, FIVE),
                new Card(SPADES, THREE),
                new Card(SPADES, FOUR),
                new Card(SPADES, SIX));

        var pokerHand = factory.createPokerHand(cards);

        assertEquals(pokerHand.handType(), STRAIGHT_FLUSH);
    }
}