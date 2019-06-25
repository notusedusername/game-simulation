package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

public enum Choice {
    FIRST,
    LAST;

    public int getIndex(Deck deck, Choice choice) {
        if (choice == Choice.FIRST) {
            return 0;
        } else {
            return deck.getDeck().size() - 1;
        }
    }
}
