package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

import java.util.ArrayList;

/**
 * A B játékos osztálya.
 */
public class PlayerB extends Player {

    private ArrayList<Integer> hand = new ArrayList<>();

    /**
     * A B játékos (DIY) stratégiája.
     *
     * @param deck a pakli
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

    private int prePlay(Deck testDeck) {
        return getSelectableElement(Choice.FIRST, testDeck) + getSelectableElement(Choice.LAST, testDeck);
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

}
