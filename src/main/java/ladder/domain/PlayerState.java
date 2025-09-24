package ladder.domain;

public class PlayerState {
    private final int rowIndex;      // 현재 행
    private final Position position; // 현재 열

    private PlayerState(int rowIndex, Position position) {
        this.rowIndex = rowIndex;
        this.position = position;
    }

    public static PlayerState from(int rowIndex, Position position) {
        return new PlayerState(rowIndex, position);
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public Position getPosition() {
        return position;
    }

    public PlayerState moveNext(Row row) {
        Position newPos = row.moveNextPosition(position);
        return new PlayerState(rowIndex + 1, newPos);
    }
}
