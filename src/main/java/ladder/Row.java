package ladder;

import ladder.position.LadderPosition;
import ladder.position.Position;

public class Row {

    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson){
        nodes = new Node[numberOfPerson.getNumber()];
        for(int i = 0; i < numberOfPerson.getNumber(); i++){
            nodes[i] = Node.from(Direction.NONE);
        }
    }

    public void nextPosition(Position position){
        validatePosition(position);
        nodes[position.getValue()].move(position);
    }

    public void generateRow(StringBuilder sb, Position currentPosition, LadderPosition ladderPosition) {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].appendSymbol(sb); //LEFT(-1), RIGHT(1)
            markCurrentPosition(sb, currentPosition, ladderPosition, i);
        }
        sb.append("\n");
    }

    private void markCurrentPosition(StringBuilder sb, Position currentPosition, LadderPosition ladderPosition, int i) {
        if (LadderPosition.of(currentPosition, Position.from(i)).equals(ladderPosition)) {
            sb.append("*");
        }
        sb.append(" ");
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
        return nodes[position.getValue()].isAlreadtSetDirection();
    }

}
