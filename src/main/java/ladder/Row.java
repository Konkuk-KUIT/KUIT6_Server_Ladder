package ladder;

import java.util.Arrays;

public class Row {

    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson){
        nodes = new Node[numberOfPerson.getNumber()];
        for(int i = 0; i < numberOfPerson.getNumber(); i++){
            nodes[i] = Node.from(Direction.NONE);
        }
    }

    public boolean nextPosition(Position position){
        validatePosition(position);
        return nodes[position.getValue()].move(position);
    }

    private void validatePosition(Position position) {
        if(isInvalidPosition(position)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1);
    }

    public void drawLine(Position startPosition){
        validateDrawLinePosition(startPosition);
        setDirectionBetweenNextPosition(startPosition);
    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getValue()].setRightNode();
        position.next();
        nodes[position.getValue()].setLeftNode();
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage()+" Position: "+startPosition.getValue());
        }
    }

    private boolean isLineAtNextPosition(Position position) {
        position.next();
        boolean lineAtPosition = isLineAtPosition(position);
        position.prev();
        return lineAtPosition;
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getValue()].isAlreadtSetDirection();
    }

    @Override
    public String toString() {
        return Arrays.toString(nodes).replace("[", "").replace("]", "").replace(",", "");
    }

    public int size() {
        return nodes.length;
    }
}
