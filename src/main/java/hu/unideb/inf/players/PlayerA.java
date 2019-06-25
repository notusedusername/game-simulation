package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

import java.util.ArrayList;

/**
 * Az A játékos osztálya, ez a játékos mindig a lehető legnagyobb
 * számot választja.
 */
public class PlayerA extends Player {

    private ArrayList<Integer> hand = new ArrayList<>();

    /**
     * Az A játékos (adott) stratégiája.
     * Kiválasztja a legnagyobb választható elemet.
     *
     * @param deck A pakli, amiből választani lehet.
     * @return A nagyobb értéket a két választható közül, vagy a másodikat ha egyenlőek.
     */
    public int selectElement(Deck deck) {
        return chooseSelectableElement(Choice.BIGGER, deck);
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

}
