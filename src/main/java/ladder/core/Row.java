package ladder.core;

import ladder.exception.ErrorMessage;
import ladder.position.LadderPosition;
import ladder.position.Position;
import ladder.util.GreaterThanOne;

public class Row {

    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for(int i = 0; i < numberOfPerson.getNumber(); i++){
            nodes[i] = Node.from(Direction.NONE);
        }
    }

    public String renderLine(LadderPosition starPos) {
        StringBuilder sb = new StringBuilder(nodes.length * 3);
        for (int c = 0; c < nodes.length; c++) {
            if (c > 0) sb.append(' ');
            String cell = nodes[c].isLeft() ? "-1" : "1"; // 오른쪽 끝이면 -1, 그 외 1
            if (starPos != null && starPos.col() == c) cell = cell + "*"; // ★ 행정보 불필요
            sb.append(cell);
        }
        return sb.toString();
    }



    public void nextPosition(Position position){
        validatePosition(position);
        int i = position.getValue();
        if (nodes[i].isLeft())  { position.prev(); return; }// 오른쪽 끝에 서 있으면 왼쪽으로
        if (nodes[i].isRight()) { position.next(); return; };
        if (i - 1 >= 0 && nodes[i - 1].isRight()) { position.prev(); return; }
        if (i + 1 < nodes.length && nodes[i + 1].isLeft()) { position.next(); }


    }


    private void validatePosition(Position position){
        int idx = position.getValue();
        if (idx < 0 || idx >= nodes.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }


    public void drawLine(Position startPosition){
        int i = startPosition.getValue();
        if (i < 0 || i >= nodes.length - 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
        if (nodes[i].isAleadySetDirection() || nodes[i + 1].isAleadySetDirection()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
        nodes[i].setRightNode();
        nodes[i + 1].setLeftNode();

    }

    public int countLines() {
        int cnt = 0;
        for (int i = 0; i < nodes.length - 1; i++) {
            if (nodes[i].isRight()) cnt++; // 시작점만 센다
        }
        return cnt;
    }


}
