package hu.unideb.inf.game;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class can fill the {@link Deck} class with cards that
 * have random values.
 */
class DeckGenerator {

    /**
     * Generates a new Deck with 1000 random values in range 0 and
     * the param {@code limit}.
     * @return the filled Deck object.
     */
    static Deck generateNewDeck(int limit) {
        Deck deck = new Deck();
        deck.setDeck(new ArrayList<Integer>());
        Random random = new Random();
        int card;

        for (int i = 0; i < 1000; i++) {
            card = random.nextInt(limit - 2) + 1;
            deck.getDeck().add(card);
        }
        return deck;
    }
}
