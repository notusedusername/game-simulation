package hu.unideb.inf.simulation;

import hu.unideb.inf.game.EndState;
import hu.unideb.inf.game.GameMode;
import hu.unideb.inf.game.Main;

public class Simulation {

    private int wins;
    private int ties;
    private int loses;
    private int time;

    public void simulateGames(int limit) {
        int timer = 10;
        for (int i = 0; i < limit; i++) {

            if (i == timer) {
                System.out.println((System.nanoTime() - Main.startTime) / 1000000);
                timer *= 10;
            }
            EndState endState = GameMode.simulate();
            if (endState == EndState.WIN) {
                wins++;
            } else if (endState == EndState.TIE) {
                ties++;
            } else {
                loses++;
            }
        }
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
