package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

import java.util.ArrayList;

/**
 * Class of Player B.
 */
public class PlayerB extends Player {

    private ArrayList<Integer> hand = new ArrayList<>();
    private ArrayList<Choice> operators = new ArrayList<>();
    private ArrayList<Choice> plannedChoices = new ArrayList<>();
    private Node bestChoice;
    private int limit;
    private int max;

    /**
     * Initializes the selectable operators, and the limit.
     */
    public PlayerB(int limit) {
        operators.add(Choice.FIRST);
        operators.add(Choice.LAST);
        this.limit = limit;
    }
    /**
     * The strategy of the player B. It uses a modded depth solution finder.
     * If there is planned moves, then makes it, else creates a new plan,
     * then start to execute it.
     *
     * @param deck the deck
     */
    public int selectElement(Deck deck) {

        if (plannedChoices.isEmpty()) {
            updateLimit(deck);
            planChoices(new Deck(deck.getDeck()));
            traceBestChoice();
        }

        return chooseSelectableElement(plannedChoices.remove(plannedChoices.size() - 1), deck);
    }

    /**
     * Controls the solution finder, examines all the possibilities.
     *
     * @param state the state to examine
     */
    private void planChoices(Deck state) {
        max = 0;

        Node node = new Node(state, 0, null, null, 0, false);
        Node choosedNode = null;
        ArrayList<Node> opened = new ArrayList<>();
        ArrayList<Node> closed = new ArrayList<>();
        opened.add(node);
        while (true) {
            if (opened.isEmpty()) {
                break;
            }
            choosedNode = chooseNode(opened);

            if (choosedNode == null) {
                break;
            }

            extend(choosedNode, opened, closed);
        }

    }

    /**
     * Gets all the possible next step, in case player A it only
     * get the bigger choose.
     *
     * @param node   the current node
     * @param opened the nodes waiting for examination
     * @param closed the nodes that was already examined
     */
    private void extend(Node node, ArrayList<Node> opened, ArrayList<Node> closed) {
        if (node.isPlayerBMove()) {
            Deck newState = new Deck(node.getState().getDeck());
            int choosedValue = chooseSelectableElement(Choice.BIGGER, newState);
            opened.add(new Node(newState, 0, node, Choice.BIGGER, node.getDepth() + 1, false));
        } else {
            for (Choice i : operators) {
                Deck newState = new Deck(node.getState().getDeck());
                int choosedValue = chooseSelectableElement(i, newState);
                opened.add(new Node(newState, node.getValue() + choosedValue, node, i, node.getDepth() + 1, true));
            }
        }
        opened.remove(node);
        closed.add(node);
    }

    /**
     * Choose a node from the opened ones. It gets always the last item,
     * it has the biggest depth. If this node is the current best, updates the
     * {@code bestChoice}.
     *
     * @param opened the nodes waiting for examination
     * @return the choosed node in range of the limit
     */
    private Node chooseNode(ArrayList<Node> opened) {
        Node choosedNode = opened.get(opened.size() - 1);
        while (choosedNode.getDepth() >= limit) {
            if (max < choosedNode.getValue()) {
                max = choosedNode.getValue();
                bestChoice = choosedNode;
            }
            opened.remove(choosedNode);
            opened.remove(choosedNode.getParent());
            if (opened.size() >= 1) {
                choosedNode = opened.get(opened.size() - 1);
            } else {
                choosedNode = null;
                break;
            }
        }
        return choosedNode;
    }

    /**
     * Tracks the way from the best possibility back to the current state.
     * Fills up the {@code plannedChoices} with the operators.
     */
    private void traceBestChoice() {
        int iterator = 0;
        while (bestChoice.getParent() != null) {
            if (iterator % 2 == 0) {
                plannedChoices.add(bestChoice.getOperator());
                bestChoice = bestChoice.getParent();
            } else {
                bestChoice = bestChoice.getParent();
            }
            iterator++;
        }
    }

    /**
     * Updates the limit, if the deck doesn't have as many items,
     * as the limit
     * @param deck the deck
     */
    private void updateLimit(Deck deck) {
        if (deck.getDeck().size() < limit) {
            limit = deck.getDeck().size();
        }
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

}
