package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;


/**
 * A játékos ősosztály. Minden játékos csak az első, vagy az
 * utolsó elemet veheti el, így ezek az operátorok.
 */
class Player {
    /**
     * Visszaadja a választott elemet ({@code Choice}), de nem
     * változtatja az adatokat.
     * @param choice Choice objektum, melyik elemet kéri
     * @param deck a pakli
     * @return a Choice alapján elért elem értéke
     */
    int getSelectableElement(Choice choice, Deck deck) {
        return deck.getDeck().get(choice.getIndex(deck, choice));
    }
    /**
     * Visszaadja a választott elemet ({@code Choice}), és
     * változtatja az adatokat, kiveszi ezt az elemet a pakliból.
     * @param choice Choice objektum, melyik elemet kéri
     * @param deck a pakli
     * @return a Choice alapján elért elem értéke
     */
    int chooseSelectableElement(Choice choice, Deck deck) {
        return deck.getDeck().remove(choice.getIndex(deck, choice));
    }

}
