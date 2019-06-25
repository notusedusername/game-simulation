package hu.unideb.inf.game;

import hu.unideb.inf.graphics.MainApp;
import hu.unideb.inf.simulation.Simulation;


public class Main {
    public static long startTime;

    public static void main(String[] args) {
        startTime = System.nanoTime();
        Simulation simulation = new Simulation();
        simulation.simulateGames(1000000);
        //MainApp.main(args);

    }
}
