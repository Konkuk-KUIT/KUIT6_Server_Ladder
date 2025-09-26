package Ladder.Core;

import Ladder.Ladder.LadderPosition;

public class Row {
    private final Node[] nodes;
    private StringBuilder stringBuilder;

    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.from(Direction.NONE);
        }
    }

    public void nextPosition(Position position) {
        validatePosition(position);
        nodes[position.getValue()].move(position);
    }

    private void validatePosition(Position position) {
        if(isInvalidatePosition(position)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }

    private boolean isInvalidatePosition(Position position) {
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

    public void generateRow(Position generateRowPosition, LadderPosition currentPosition) {
        stringBuilder = new StringBuilder();
        for (int j = 0; j < nodes.length; j++) {
            stringBuilder.append(nodes[j].getDirection().getValue());
            printItSelf(generateRowPosition, currentPosition, j);
            stringBuilder.append('\t');
        }
        System.out.print(stringBuilder.toString());
    }

    private void printItSelf(Position generateRowPosition, LadderPosition currentPosition, int printColPosition) {
        if (currentPosition.isEqual(generateRowPosition, Position.from(printColPosition))) {
            stringBuilder.append("*");
        }
    }

}
