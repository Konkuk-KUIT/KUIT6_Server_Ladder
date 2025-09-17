public class Exception {
    private int[][] rows;

    public Exception(int[][] rows) {
        this.rows = rows;
    }

    private void inBound(int row, int col) {
        if (row < 0 || row >= rows.length || col < 0 || col >= rows[0].length) {
            throw new IllegalArgumentException("잘못된 범위");
        }
    }

    private void hasNextLine(int row, int col) {
        if ((col < rows[0].length - 1  && rows[row][col + 1] == 1) || (col > 0 && rows[row][col - 1] == 1)) {
            throw new IllegalArgumentException("같은 높이에서 연속된 선 불가능");
        }
    }

    private void overlapCheck(int row, int col) {
        if (rows[row][col] == 1) {
            throw new IllegalArgumentException("중복된 선");
        }
    }

    public void check(int row, int col){
        inBound(row, col);
        overlapCheck(row, col);
        hasNextLine(row, col);
    }

}
