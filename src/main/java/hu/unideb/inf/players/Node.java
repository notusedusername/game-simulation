package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

/**
 * Class of the modded AI depth search.
 * Every node is a state of the deck, but the
 * parent, the used operator, and the player who made the move
 * are available too.
 */
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
