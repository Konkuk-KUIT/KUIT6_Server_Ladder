package ladder.creator;

import ladder.util.GreaterThanOne;

public class LadderSize {
    private final GreaterThanOne rows;
    private final GreaterThanOne cols;

    public LadderSize(GreaterThanOne rows, GreaterThanOne cols) {
        this.rows = rows;
        this.cols = cols;
    }
    public GreaterThanOne rowsAsGTO() { return rows; }
    public GreaterThanOne colsAsGTO() { return cols; }

    public int rows() { return rows.getNumber(); }
    public int cols() { return cols.getNumber(); }

    /** 정책: (행 * 열) * 0.3 (내림) */
    public int targetLines() {
        int total = rows() * cols();
        return (int) Math.floor(total * 0.3);
    }
}