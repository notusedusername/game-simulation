package hu.unideb.inf.players;

import java.util.ArrayList;

/**
 * A B játékos osztálya.
 */
public class PlayerB extends Player {

    private static ArrayList<Integer> hand = new ArrayList<>();

    private static int[] possibilies = new int[2];

    /**
     * A B játékos (DIY) stratégiája.
     *
     * @param deck a pakli
     */
    public static int selectElement(ArrayList<Integer> deck) {
        int selectFirst = 0, selectSecond = 0;
        for (int i = 0; i < 2; i++) {
            ArrayList<Integer> test = new ArrayList<>(deck);
            if (i == 0) {
                getLessElement(test);
                selectFirst = prePlay(test);
            } else {
                getBiggerElement(test);
                selectSecond = prePlay(test);

            }
        }
        if (selectFirst > selectSecond) {
            return deck.remove(0);
        } else {
            return deck.remove(deck.size() - 1);
        }
    }

    private static int prePlay(ArrayList<Integer> testDeck) {
        if (testDeck.size() != 0) {
            getBiggerElement(testDeck);
            return getBiggerElement(testDeck);
        } else {
            return 0;
        }
    }

    public static ArrayList<Integer> getHand() {
        return hand;
    }

    public static void setHand(ArrayList<Integer> hand) {
        PlayerB.hand = hand;
    }
}
