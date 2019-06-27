package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

import java.util.ArrayList;


/**
 * The Player parent class, contains the default operations
 * of a player (examine item, get item).
 */
class Player {
    /**
     * Gets the choosed item, but does not affect its value.
     * @param choice the {@link Choice}
     * @param deck the deck
     * @return the value of the choosed item
     */
    int getSelectableElement(Choice choice, Deck deck) {
        return deck.getDeck().get(choice.getIndex(deck, choice));
    }
    /**
     * Choose the selected item, removes the item from the deck.
     * @param choice the {@link Choice}
     * @param deck the deck
     * @return the value of the removed item
     */
    int chooseSelectableElement(Choice choice, Deck deck) {
        return deck.getDeck().remove(choice.getIndex(deck, choice));

    }

}
