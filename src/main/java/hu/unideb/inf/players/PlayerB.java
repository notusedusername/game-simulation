package hu.unideb.inf.players;

import hu.unideb.inf.game.Deck;

import java.util.ArrayList;

/**
 * A B játékos osztálya.
 */
public class PlayerB extends Player {//fixme 10% win rate

    private ArrayList<Integer> hand = new ArrayList<>();
    private ArrayList<Choice> operators = new ArrayList<>();
    private ArrayList<Choice> plannedChoices = new ArrayList<>();
    private Node bestChoice;
    private int limit;

    public PlayerB() {
        operators.add(Choice.FIRST);
        operators.add(Choice.LAST);
        limit = 5;
    }
    /**
     * A B játékos (DIY) stratégiája.
     *
     * @param deck a pakli
     */
    public int selectElement(Deck deck) {

        /*if (deck.getDeck().size() > 2) {
            int selectFirst, selectSecond;
            Deck test = new Deck(deck.getDeck());
            chooseSelectableElement(Choice.FIRST, test);
            selectFirst = predict(test);

            test = new Deck(deck.getDeck());
            chooseSelectableElement(Choice.LAST, test);
            selectSecond = predict(test);

            if (selectFirst < selectSecond) {
                return chooseSelectableElement(Choice.FIRST, deck);
            } else {
                return chooseSelectableElement(Choice.LAST, deck);
            }
        } else {
            return chooseSelectableElement(Choice.BIGGER, deck);
        }
        */
        if (plannedChoices.isEmpty()) {
            updateLimit(deck);
            planChoices(new Deck(deck.getDeck()));
            traceBestChoice();
        }
        return chooseSelectableElement(plannedChoices.get(plannedChoices.size() - 1), deck);
    }

    private void planChoices(Deck state) {
        int max = 0;

        Node node = new Node(state, 0, null, null, 0, false);
        Node choosedNode = null;
        ArrayList<Node> opened = new ArrayList<>();
        ArrayList<Node> closed = new ArrayList<>();
        opened.add(node);
        while (true) {
            if (opened.isEmpty()) {
                break;
            }
            choosedNode = chooseNode(opened, max);

            if (choosedNode == null) {
                break;
            }

            extend(choosedNode, opened, closed);
        }

    }

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

    private Node chooseNode(ArrayList<Node> opened, int max) {
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

    private void updateLimit(Deck deck) {
        if (deck.getDeck().size() < 5) {
            limit = deck.getDeck().size();
        }
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

}
