package pokerhands.logic;

/**
 * Contains a playing card value and its number of occurrences.
 * @param cardValue The card value.
 * @param occurrences The number of times a card with the occurred in a hand.
 */
public record CardValueOccurrence(CardValue cardValue, int occurrences) { }
