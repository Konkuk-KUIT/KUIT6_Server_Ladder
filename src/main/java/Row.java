public class Row {
    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for(int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.from(Direction.NONE);
        }
    }

    public void drawLine(Position position) {
        validateDrawLinePosition(position);
        setAdjacentNode(position);
    }

    private void setAdjacentNode(Position position) {
        nodes[position.getPosition()].setRightNode();
        nodes[position.getPosition() + 1].setLeftNode();
    }

    public void goToNext(Position position) {
        validatePosition(position);
        nodes[position.getPosition()].move(position);
    }

    private void validatePosition(Position position) {
        if(isInvalidPosition(position)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1);
    }

    private void validateDrawLinePosition(Position position) {
        validatePosition(position);
        validateLastLine(position);
        if(isLineAtPosition(position) || isLineAtNextPosition(position)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private void validateLastLine(Position position) {
        if(isLastLine(position)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isLastLine(Position position) {
        return position.getPosition() == nodes.length - 1;
    }

    private boolean isLineAtNextPosition(Position position) {
        position.next();
        boolean isAlreadySetNextNode = isLineAtPosition(position);
        position.prev();
        return isAlreadySetNextNode;
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getPosition()].isAlreadySet();
}
}
