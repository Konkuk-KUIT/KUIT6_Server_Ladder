public class Node {
    private LadderDirection direction;

    private Node(LadderDirection direction) {
        this.direction = direction;
    }

    public static Node from(LadderDirection direction) {
        return new Node(direction);
    }

    public void move(PlayerPosition position) {
        if (isLeft()) {
            position.prev();
            return;
        }

        if (isRight()) {
            position.next();
            return;
        }
    }

    public void setRightNode() {
        direction = LadderDirection.Right;
    }

    public void setLeftNode() {
        direction = LadderDirection.Left;
    }

    public boolean isAlreadySetDirection() {
        return !isNone();
    }

    private boolean isNone() {
        return direction == LadderDirection.None;
    }

    private boolean isRight() {
        return direction == LadderDirection.Right;
    }

    private boolean isLeft() {
        return direction == LadderDirection.Left;
    }
}
