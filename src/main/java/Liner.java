public class Liner {
    private final int[][] rows;

    public Liner(int[][] rows) {
        this.rows = rows;
    }

    public void draw(int row, int col) {
        Exception exception = new Exception(rows);
        exception.check(row, col);

        rows[row][col] = 1;
    }

}
