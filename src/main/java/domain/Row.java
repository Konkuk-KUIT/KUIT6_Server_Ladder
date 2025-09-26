package domain;

public class Row {
    private final int[] columns;

    public Row(int numberOfPerson) {
        this.columns = new int[numberOfPerson];
    }

    public boolean canDrawLine(int position) {
        if (position < 0 || position >= columns.length - 1) {
            return false; // 마지막 참가자 오른쪽엔 가로줄 불가
        }
        // 이미 선이 그어져 있거나 연속된 경우 방지
        return columns[position] == 0 && columns[position + 1] == 0;
    }

    public void drawLine(int position) {
        if (!canDrawLine(position)) {
            throw new IllegalArgumentException("라인을 그릴 수 없습니다: " + position);
        }
        columns[position] = 1;
        columns[position + 1] = -1;
    }

    public Position move(Position current) {
        int idx = current.value() - 1; // 1-based → 0-based 보정
        int size = columns.length;

        if (columns[idx] == 1) {
            return current.moveRight(new NaturalNumber(size));
        }
        if (columns[idx] == -1) {
            return current.moveLeft(new NaturalNumber(size));
        }
        return current;
    }

    public int[] getColumns() {
        return columns;
    }
}
