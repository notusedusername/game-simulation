package hu.unideb.inf.game;

import hu.unideb.inf.players.PlayerA;
import hu.unideb.inf.players.PlayerB;

import java.util.ArrayList;
import java.util.Random;

/**
 * This game mode simulates a single game with computer controlled
 * players.
 */
public class GameMode {

    private static PlayerA playerA;
    private static PlayerB playerB;
    private static Deck generatedDeck;

    /**
     * Initializes the class variables.
     */
    private static void initialize() {
        generatedDeck = DeckGenerator.generateNewDeck(10000);
        playerA = new PlayerA();
        playerB = new PlayerB();
    }

    /**
     * Simulates a single game.
     *
     * @return the end state value of the game for the player B.
     */
    public static EndState simulate() {
        initialize();

        playGame();

        return evaluateEndState();
    }

    /**
     * Runs a game with random first player.
     */
    private static void playGame() {
        try {
            if (new Random().nextBoolean()) {
                for (int i = 0; i < 500; i++) {
                    playerA.getHand().add(playerA.selectElement(generatedDeck));
                    playerB.getHand().add(playerB.selectElement(generatedDeck));
                }

            } else {
                for (int i = 0; i < 500; i++) {
                    playerB.getHand().add(playerB.selectElement(generatedDeck));
                    playerA.getHand().add(playerA.selectElement(generatedDeck));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Evaluates the end state of the game, there is win, lose and tie for the
     * player B.
     *
     * @return the end state value.
     */
    private static EndState evaluateEndState() {
        int sumOfA = accumulate(playerA.getHand());
        int sumOfB = accumulate(playerB.getHand());
        if (sumOfA < sumOfB) {
            return EndState.WIN;
        } else if (sumOfA == sumOfB) {
            return EndState.TIE;
        } else {
            return EndState.LOSE;
        }
    }

    /**
     * Sums elements of the param {@code ArrayList}.
     *
     * @param target {@code ArrayList} to sum
     * @return the sum value.
     */
    private static int accumulate(ArrayList<Integer> target) {
        return target.stream().mapToInt(Integer::intValue).sum();
    }
}
