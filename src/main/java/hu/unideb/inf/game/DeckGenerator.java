package hu.unideb.inf.game;

import java.util.ArrayList;
import java.util.Random;

/**
 * A Deck osztály frissítésére szolgáló osztály.
 */
public class DeckGenerator {

    /**
     * Egy új paklit generál a régi ürítésével.
     */
    public static Deck generateNewDeck() {
        Deck deck = new Deck();
        deck.setDeck(new ArrayList<Integer>());
        Random random = new Random();
        int card = 0;

        for (int i = 0; i < 1000; i++) {
            card = random.nextInt(9998) + 1;
            deck.getDeck().add(card);
        }
        return deck;
    }
}
