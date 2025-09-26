package ladder.position;

public final class LadderPosition {
    private final int row; // y
    private final int col; // x
    private LadderPosition(int row, int col){ this.row=row; this.col=col; }
    public static LadderPosition of(int row, int col){ return new LadderPosition(row, col); }

    public int row() { return row; }
    public int col() { return col; }

    public boolean isAt(int r, int c){ return this.row==r && this.col==c; }
}
