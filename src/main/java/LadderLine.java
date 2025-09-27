import java.util.Arrays;

public class LadderLine {
    private final Node[] nodes;

    public LadderLine(GreaterThanOne playerCount) {
        this.nodes = new Node[playerCount.getNumber()];
        Arrays.setAll(nodes, i -> Node.from(LadderDirection.None));
    }

    public void drawLine(PlayerPosition position) {
        validateDrawLinePosition(position);
        setDirectionBetweenNextPosition(position);
    }

    private void setDirectionBetweenNextPosition(PlayerPosition position) {
        nodes[position.getValue()].setRightNode();
        position.next();
        nodes[position.getValue()].setLeftNode();
    }

    public void move(PlayerPosition position) {
        validatePosition(position);
        nodes[position.getValue()].move(position);
    }

    private void validatePosition(PlayerPosition position) {
        if (position.getValue() < 0 || position.getValue() >= nodes.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(PlayerPosition position) {
        validatePosition(position);

        if (position.getValue() == nodes.length - 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
        if (isLineAtPosition(position) || isLineNextPosition(position)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isLineNextPosition(PlayerPosition position) {
        position.next();
        boolean lineAtNext = isLineAtPosition(position);
        position.prev();
        return lineAtNext;
    }

    private boolean isLineAtPosition(PlayerPosition position) {
        return nodes[position.getValue()].isAlreadySetDirection();
    }

    public Node[] getNodes() {
        return nodes;
    }
}