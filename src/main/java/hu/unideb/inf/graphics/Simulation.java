package hu.unideb.inf.graphics;

import hu.unideb.inf.game.EndState;
import hu.unideb.inf.game.GameMode;
import hu.unideb.inf.game.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


/**
 * This class handles the results of the simulations.
 */
public class Simulation {

    @FXML
    VBox list;
    @FXML
    Button startButton;

    private long startTime;
    private int wins;
    private int ties;
    private int loses;

    /**
     * Simulates games for {@code limit} times, and updates the class variables.
     *
     * @param limit the limit of the number of simulations
     */
    private void simulateGames(int limit) {
        int timer = 10;
        startTime = System.nanoTime();
        for (int i = 0; i < limit; i++) {

            EndState endState = GameMode.simulate();
            if (endState == EndState.WIN) {
                wins++;
            } else if (endState == EndState.TIE) {
                ties++;
            } else {
                loses++;
            }

            if (i == timer - 1) {
                final int counter = i;
                Platform.runLater(() -> {
                    Label header = new Label("Simulation ran " + (counter + 1) + " times");
                    Label time = new Label("Elapsed time: " + (System.nanoTime() - startTime) / 1000000 + " ms");
                    Label stats = new Label("Stats: " + "wins: " + wins + " loses:" + loses + " ties: " + ties);
                    header.getStyleClass().add("header");
                    list.getChildren().addAll(header, time, stats);
                });

                timer *= 10;
            }
        }
    }

    public void handleStart(ActionEvent actionEvent) {

        wins = 0;
        loses = 0;
        ties = 0;

        Runnable task = () -> {
            startButton.disableProperty().setValue(true);
            simulateGames(1000000);
        };
        Thread backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();

        startButton.disableProperty().setValue(false);
    }

    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }

}
