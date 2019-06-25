package hu.unideb.inf.players;

import java.util.ArrayList;

/**
 * Az A játékos osztálya, ez a játékos mindig a lehető legnagyobb
 * számot választja.
 */
public class PlayerA extends Player {

    private static ArrayList<Integer> hand = new ArrayList<>();

    /**
     * Az A játékos (adott) stratégiája.
     * Kiválasztja a legnagyobb választható elemet.
     *
     * @param deck A pakli, amiből választani lehet.
     * @return A nagyobb értéket a két választható közül, vagy a másodikat ha egyenlőek.
     */
    public static int selectElement(ArrayList<Integer> deck) {
        return getBiggerElement(deck);
    }

    public static ArrayList<Integer> getHand() {
        return hand;
    }

    public static void setHand(ArrayList<Integer> hand) {
        PlayerA.hand = hand;
    }

}
