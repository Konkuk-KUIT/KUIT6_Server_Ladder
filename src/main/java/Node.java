public class Node {
    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }
    public static Node from(Direction direction) {
        return new Node(direction);
    }

    public void move(Position position) {
        if(isRight()) {
            position.next();
            return;
        }

        if(isLeft()) {
            position.prev();
            return;
        }
    }

    private boolean isRight() {
        return direction == Direction.RIGHT;
    }
    private boolean isLeft() {
        return direction == Direction.LEFT;
    }
    private boolean isNone() {
        return direction == Direction.NONE;
    }

    public void setRightNode(){
        direction = Direction.RIGHT;
    }
    public void setLeftNode(){
        direction = Direction.LEFT;
    }

    public boolean isAlreadySet() {
        return !isNone();
    }

    public int getDirectionValue() {
        return direction.getValue();
    }

    public StringBuilder valueToStringBuilder() {
        return new StringBuilder().append(getDirectionValue());
    }
}
