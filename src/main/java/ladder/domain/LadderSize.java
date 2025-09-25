package ladder.domain;

import ladder.support.ErrorMessage;

public final class LadderSize {
    private final int rows;
    private final int persons;

    public LadderSize(int rows, int persons) {
        if (rows < 2 || persons < 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_NUMBER.getMessage());
        }
        this.rows = rows;
        this.persons = persons;
    }

    public int rows()    { return rows; }
    public int persons() { return persons; }

    // 총 가로선 규칙: floor(rows * persons * 0.3)
    public int targetLines() {
        return (int) Math.floor(rows * persons * 0.3);
    }
}
