package ladder.core;

import ladder.position.Position;

public class Node {
    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node from(Direction direction) {
        return new Node(direction);
    }

    public void move(Position position) {
        if (isLeft()) {
            position.prev();
            return;
        }

        if (isRight()) {
            position.next();
            return;
        }
    }

    public void setRightNode(){
        direction = Direction.RIGHT;
    }

    public void setLeftNode(){
        direction = Direction.LEFT;
    }

    public boolean isAlreadtSetDirection(){
        return !isNone();
    }

    public void appendSymbol(StringBuilder sb) {
        sb.append(direction.getValue());
    }

    private boolean isNone() {
        return direction == Direction.NONE;
    }

    private boolean isRight() {
        return direction == Direction.RIGHT;
    }

    private boolean isLeft() {
        return direction == Direction.LEFT;
    }
}
