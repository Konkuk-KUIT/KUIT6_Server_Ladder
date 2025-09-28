package ladder.unit;

import ladder.exception.ErrorMessage;
import ladder.util.GreaterThanOne;

public class Row {

    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson){
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.from(Direction.NONE);
        }
    }

    public StringBuilder createRowString(LadderPosition ladderPosition, int rowNumber) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i].getValue());
            printCurrentPosition(ladderPosition, rowNumber, i, sb);
            sb.append(" ");
        }
        return sb;
    }

    private static void printCurrentPosition(LadderPosition ladderPosition, int rowNumber, int i, StringBuilder sb) {
        if (ladderPosition.equals(LadderPosition.of(rowNumber, Position.from(i)))) {
            sb.append("*");
        }
    }

    public void nextPosition(Position position){
        validatePosition(position);
        nodes[position.getValue()].move(position);
    }

    private void validatePosition(Position position) {
        if(isInvalidPosition(position)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length -1);
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
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isLineAtNextPosition(Position position) {
        position.next();
        boolean lineAtPosition = isLineAtPosition(position);
        position.prev();
        return lineAtPosition;
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getValue()].isAlreadySetDirection();
    }
}