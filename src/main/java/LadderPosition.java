public class LadderPosition {
    //Todo 리팩토링
    private final int row;
    private final int col;

    public LadderPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    /*
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof LadderPosition)) return false;
        LadderPosition that = (LadderPosition) o;
        return row == that.row && col == that.col;
    }
    @Override
    public int hashCode() {
        return 31 * row + col;
    }
     */
}

