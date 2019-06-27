package hu.unideb.inf.game;

import java.util.ArrayList;

/**
 * The {@code Deck} can contain a deck of cards with Integer values.
 */
public class Deck {

    private ArrayList<Integer> deck;

    public ArrayList<Integer> getDeck() {
        return deck;
    }

    void setDeck(ArrayList<Integer> deck) {
        this.deck = deck;
    }

    Deck() {
        this.deck = new ArrayList<>();
    }

    public Deck(ArrayList<Integer> deck) {
        this.deck = new ArrayList<>(deck);
    }
}
