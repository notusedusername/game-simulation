package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

import java.util.ArrayList;

/**
 * The class of player B. The player B uses a defending tactic,
 * tries to block the other player.
 */
public class PlayerB extends Player {

    private ArrayList<Integer> hand = new ArrayList<>();

    /**
     * The strategy of player B.
     *
     * The main tactics is defending, the player B tries to block
     * the bigger numbers from the player A by not choose numbers,
     * that have the better number (for A) next to them. B examines each the
     * possibilities before the move (only 2), and choose the better.
     * A possibility is better, than the other, when the other player could have advantage,
     * if this player choose the other.
     *
     * @param deck the deck
     */
    public int selectElement(Deck deck) {
        if (deck.getDeck().size() > 1) {
            int selectFirst, selectSecond;
            Deck test = new Deck(deck.getDeck());
            chooseSelectableElement(Choice.FIRST, test);
            selectFirst = prePlay(test);

            test = new Deck(deck.getDeck());
            chooseSelectableElement(Choice.LAST, test);
            selectSecond = prePlay(test);

            if (selectFirst < selectSecond) {
                return chooseSelectableElement(Choice.FIRST, deck);
            } else {
                return chooseSelectableElement(Choice.LAST, deck);
            }
        } else {
            return chooseSelectableElement(Choice.LAST, deck);
        }

    }

    /**
     * Returns the consequence of the move, it calculates the selectable items sum.
     * The less sum means less value for the next player.
     * @param testDeck the deck to examine
     * @return the sum of selectable items
     */
    private int prePlay(Deck testDeck) {
        return getSelectableElement(Choice.FIRST, testDeck) + getSelectableElement(Choice.LAST, testDeck);
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

}
