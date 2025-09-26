package ladder.core;

public class Node {
    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node from(Direction direction) {
        return new Node(direction);
    }

    public void setRightNode(){
        direction = Direction.RIGHT;
    }

    public void setLeftNode(){
        direction = Direction.LEFT;
    }

    public boolean isAleadySetDirection(){
        return direction != Direction.NONE;
    }

    public boolean isNone(){
        return direction == Direction.NONE;
    }

    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public boolean isLeft() {
        return direction == Direction.LEFT;
    }
}
