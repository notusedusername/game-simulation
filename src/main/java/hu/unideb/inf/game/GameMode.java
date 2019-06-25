package hu.unideb.inf.game;

import hu.unideb.inf.players.PlayerA;
import hu.unideb.inf.players.PlayerB;

import java.util.ArrayList;

public class GameMode {

    public static EndState simulate() {

        Deck generatedDeck = DeckGenerator.generateNewDeck();
        PlayerA.setHand(new ArrayList<>());
        PlayerB.setHand(new ArrayList<>());

        for (int i = 0; i < 500; i++) {
            PlayerA.getHand().add(PlayerA.selectElement(generatedDeck.getDeck()));
            PlayerB.getHand().add(PlayerB.selectElement(generatedDeck.getDeck()));
        }
        int sumOfA = accumulate(PlayerA.getHand());
        int sumOfB = accumulate(PlayerB.getHand());
        if (sumOfA < sumOfB) {
            return EndState.WIN;
        } else if (sumOfA == sumOfB) {
            return EndState.TIE;
        } else {
            return EndState.LOSE;
        }
    }

    private static int accumulate(ArrayList<Integer> target) {
        return target.stream().mapToInt(Integer::intValue).sum();
    }
}
