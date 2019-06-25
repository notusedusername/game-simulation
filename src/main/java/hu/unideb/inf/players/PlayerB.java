package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

import java.util.ArrayList;

/**
 * A B játékos osztálya.
 */
public class PlayerB extends Player {

    private ArrayList<Integer> hand = new ArrayList<>();

    private int[] possibilies = new int[2];

    /**
     * A B játékos (DIY) stratégiája.
     *
     * @param deck a pakli
     */
    public int selectElement(Deck deck) {

        int selectFirst = 0, selectSecond = 0;
        for (int i = 0; i < 2; i++) {
            Deck test = new Deck(deck.getDeck());
            if (i == 0) {
                chooseSelectableElement(Choice.LESS, test);
                selectFirst = prePlay(test);
            } else {
                chooseSelectableElement(Choice.BIGGER, test);
                selectSecond = prePlay(test);

            }
        }
        if (selectFirst > selectSecond) {
            return chooseSelectableElement(Choice.FIRST, deck);
        } else {
            return chooseSelectableElement(Choice.LAST, deck);
        }
    }

    private int prePlay(Deck testDeck) {
        if (testDeck.getDeck().size() != 0) {
            chooseSelectableElement(Choice.BIGGER, testDeck);
            return chooseSelectableElement(Choice.BIGGER, testDeck);
        } else {
            return 0;
        }


        //return chooseSelectableElement(Choice.BIGGER, deck);
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Integer> hand) {
        this.hand = hand;
    }
}
