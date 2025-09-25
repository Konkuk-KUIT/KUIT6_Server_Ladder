package ladder;

public class Row {

    private final Node[] nodes;
    private Position currentPosition;

    public Row(GreaterThanOne numberOfPerson){
        nodes = new Node[numberOfPerson.getNumber()];
        for(int i = 0; i < numberOfPerson.getNumber(); i++){
            nodes[i] = Node.from(Direction.NONE);
        }
        currentPosition = null;
    }

    public boolean nextPosition(Position position){
        validatePosition(position);
        currentPosition = position;
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
        return nodes[position.getValue()].isAlreadySetDirection();
    }

    public String toStringCurrent() {
        StringBuilder sb = new StringBuilder();
        int n = nodes.length;
        int cur = (currentPosition != null) ? currentPosition.getValue() : -1;

        for (int j = 0; j < n; j++) {
            sb.append(j == cur ? '*' : '|');

            // 마지막 칸 전까지만 가로연결 판단
            if (j < n - 1) {
                String left  = nodes[j].toString();
                String right = nodes[j + 1].toString();

                boolean connected = "1".equals(left) || "-1".equals(right);
                sb.append(connected ? '-' : ' ');
            }
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int n = nodes.length;
        for (int j = 0; j < n; j++) {
            sb.append('|');
            // 마지막 칸 전까지만 가로연결 판단
            if (j < n - 1) {
                String left  = nodes[j].toString();
                String right = nodes[j + 1].toString();

                boolean connected = "1".equals(left) || "-1".equals(right);
                sb.append(connected ? '-' : ' ');
            }
        }
        return sb.toString();
    }

    public void setCurrentPosition(Position position) {
        currentPosition = position;
    }

    public int size() {
        return nodes.length;
    }
}
