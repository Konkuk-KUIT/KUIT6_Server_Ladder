public class Node {

    private Direction direction;

    private Node (Direction direction){
        this.direction = direction;
    }
    public static Node from(Direction direction){
        return new Node(direction);
    }

    public void move(Position position){
        if(isRightDirection()){
            position.next();
        }
        if(isLeftDirection()){
            position.prev();
        }
    }

    public void setRightDirection(){
        this.direction = Direction.RIGHT;
    }
    public void setLeftDirection(){
        this.direction = Direction.LEFT;
    }
    public boolean isRightDirection(){
        return direction == Direction.RIGHT;
    }
    public boolean isLeftDirection(){
        return direction == Direction.LEFT;
    }
    public boolean isNoneDirection(){
        return direction == Direction.NONE;
    }
}
