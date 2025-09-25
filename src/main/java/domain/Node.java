package domain;

import game.Direction;

public class Node   {
    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node from(Direction direction) {
        return new Node(direction);
    }

//    public void move(Position position) {
//        if (isLeft()) {
//            position.prev();
//            return;
//        }
//
//        if (isRight()) {
//            position.next();
//            return;
//        }
//    }

    public void setRightNode(){
        direction = Direction.RIGHT;
    }

    public void setLeftNode(){
        direction = Direction.LEFT;
    }

    public boolean isAlreadySetDirection(){
        return !isNone();
    }

    private boolean isNone() {
        return direction == Direction.NONE;
    }

    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public boolean isLeft() {
        return direction == Direction.LEFT;
    }

    public void printNode() {
        System.out.print(direction.getValue());
    }
}
