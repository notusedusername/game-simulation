package hu.unideb.inf.game;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Integer> deck;

    public ArrayList<Integer> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Integer> deck) {
        this.deck = deck;
    }

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public Deck(ArrayList<Integer> deck) {
        this.deck = deck;
    }
}
