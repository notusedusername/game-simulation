package hu.unideb.inf.players;

import java.util.ArrayList;


/**
 * A játékos ősosztály. Minden játékos csak az első, vagy az
 * utolsó elemet veheti el, így ezek az operátorok.
 */
public class Player {

    /**
     * A pakli nagyobb választható kártyáját választja
     *
     * @param deck pakli
     * @return a nagyobb elem értéke
     */
    static int getBiggerElement(ArrayList<Integer> deck) {
        if (getFirstElement(deck) > getLastElement(deck)) {
            return deck.remove(0);
        } else {
            return deck.remove(deck.size() - 1);
        }
    }

    /**
     * A pakli kisebb választható kártyáját választja
     *
     * @param deck pakli
     * @return a kisebb elem értéke
     */
    static int getLessElement(ArrayList<Integer> deck) {
        if (getFirstElement(deck) < getLastElement(deck)) {
            return deck.remove(0);
        } else {
            return deck.remove(deck.size() - 1);
        }
    }

    /**
     * Az első elem értékét adja vissza.
     *
     * @param deck a pakli
     * @return első elem
     */
    static int getFirstElement(ArrayList<Integer> deck) {
        return deck.get(0);
    }

    /**
     * Az utolsó elem értékét adja vissza
     *
     * @param deck a pakli
     * @return az utolsó elem
     */
    static int getLastElement(ArrayList<Integer> deck) {
        return deck.get(deck.size() - 1);
    }
}
