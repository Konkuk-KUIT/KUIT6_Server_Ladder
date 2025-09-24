public class Node {
    private int direction;

    public int getValue() {
        return direction;
    }

    public Node(int direction) {
        this.direction = direction;
    }

    public void computeDirection(Position start, Position end) {
        direction = end.getX() - start.getX();
    }
}
