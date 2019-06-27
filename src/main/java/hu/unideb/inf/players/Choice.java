package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

/**
 * Contains the possible choiches of the players.
 */
public enum Choice {
    FIRST,
    LAST,
    BIGGER,
    LESS;

    /**
     * Returns the index of the choosed item in the current deck.
     *
     * @param deck   current deck
     * @param choice choice
     * @return index of item
     */
    public int getIndex(Deck deck, Choice choice) {
        if (choice == FIRST) {
            return 0;
        } else if (choice == LAST) {
            return deck.getDeck().size() - 1;
        } else if (choice == BIGGER) {
            return (deck.getDeck().get(0) > deck.getDeck().get(deck.getDeck().size() - 1)) ? 0 : deck.getDeck().size() - 1;
        } else {
            return (deck.getDeck().get(0) < deck.getDeck().get(deck.getDeck().size() - 1)) ? 0 : deck.getDeck().size() - 1;
        }
    }
}
