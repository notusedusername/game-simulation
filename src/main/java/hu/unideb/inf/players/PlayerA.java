package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

import java.util.ArrayList;

/**
 * The class of the player A. This comuter controlled player
 * always choose the biggest possible value.
 */
public class PlayerA extends Player {

    private ArrayList<Integer> hand = new ArrayList<>();

    /**
     * The strategy of player A.
     *
     * @param deck the deck
     * @return the bigger item
     */
    public int selectElement(Deck deck) {
        return chooseSelectableElement(Choice.BIGGER, deck);
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

}
