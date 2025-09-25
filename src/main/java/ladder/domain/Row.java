package ladder.domain;

import ladder.support.ErrorMessage;

public class Row {

    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()]; // 사람 수만큼 노드 생성
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.from(Direction.NONE);       // 노드 초기화
        }
    }

    public Position moveNextPosition(Position position) {
        validatePosition(position);
        return nodes[position.getValue()].move(position);
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1);
    }


    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        setDirectionBetweenNextPosition(startPosition);

    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getValue()].setRightNode();
        Position nextPosition = position.next();
        nodes[nextPosition.getValue()].setLeftNode();
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        // 추가: startPosition이 마지막 칸이면 그릴 수 없다.
        if (startPosition.getValue() >= nodes.length - 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }

        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isLineAtNextPosition(Position position) {
        Position nextPosition = position.next();
        return isLineAtPosition(nextPosition);
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getValue()].isAlreadySetDirection();
    }


    public Node[] getNodes() {
        return nodes;
    }

}
