import java.util.Arrays;

public class LadderLine {
    private final Node[] nodes;
    private final GreaterThanOne playerCount;

    public LadderLine(GreaterThanOne playerCount) {
        this.playerCount = playerCount;
        nodes = new Node[playerCount.getNumber()];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Node.from(LadderDirection.None);
        }
    }

    public void drawLine(PlayerPosition position){
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

    private void validatePosition(PlayerPosition position){
        if(isInvalidPosition(position)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(PlayerPosition position) {
        return position.isBiggerThan(nodes.length);
    }

    private void validateDrawLinePosition(PlayerPosition position){
        validatePosition(position);
        if(isLineAtPosition(position) || isLineNextPosition(position)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }


    }

    private boolean isLineNextPosition(PlayerPosition position) {
        position.next();
        boolean lineAtPosition = isLineAtPosition(position);
        position.prev();;
        return lineAtPosition;
    }

    private boolean isLineAtPosition(PlayerPosition position) {
        return nodes[position.getValue()].isAlreadySetDirection();
    }

}
