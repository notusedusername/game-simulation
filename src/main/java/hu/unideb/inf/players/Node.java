package hu.unideb.inf.players;

import static hu.unideb.inf.players.Player.*;

import hu.unideb.inf.game.Deck;


public class Node {
    private Deck state;
    private Node parent;
    private Choice operator;
    private int depth;
    private int value;
    private boolean playerBMove;

    public Node(Deck state, int value, Node parent, Choice operator, int depth, boolean playerBMove) {
        this.parent = parent;
        if (parent != null) {
            this.value = parent.getValue() + value;
        } else {
            this.value = value;
        }
        this.operator = operator;
        this.depth = depth;
        this.state = new Deck(state.getDeck());
        this.playerBMove = playerBMove;

    }

    public int getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public Choice getOperator() {
        return operator;
    }

    public Deck getState() {
        return state;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isPlayerBMove() {
        return playerBMove;
    }
}
