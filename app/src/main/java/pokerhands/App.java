package pokerhands;

import pokerhands.logic.Card;
import pokerhands.logic.OccurrenceCounter;
import pokerhands.logic.PokerHandFactory;

import static pokerhands.logic.CardSuit.*;
import static pokerhands.logic.CardValue.*;

import java.util.List;

public class App {
    public static void main(String[] args) {

        var firstHand = List.of(
                new Card(CLUBS, TWO),
                new Card(CLUBS, THREE),
                new Card(CLUBS, FOUR),
                new Card(CLUBS, FIVE),
                new Card(CLUBS, SEVEN));

        var secondHand = List.of(
                new Card(CLUBS, TWO),
                new Card(SPADES, TWO),
                new Card(CLUBS, THREE),
                new Card(DIAMONDS, TWO),
                new Card(HEARTS, THREE));

        String message;
        int comparison = CompareHands(firstHand, secondHand);
        if (comparison < 0) {
           message = "Hand 1 wins!";
        } else if (comparison > 0)  {
            message = "Hand 2 wins!";
        } else {
            message = "This is a draw!";
        }

        System.out.println(message);
    }

    public static int CompareHands(List<Card> firstHand, List<Card> secondHand) {
        var factory = new PokerHandFactory(new OccurrenceCounter());

        return factory.createPokerHand(firstHand)
                .compareTo(factory.createPokerHand((secondHand)));
    }
}
