public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][--numberOfPerson];
    }

    public void drawLine(int row, int col) {
        Liner liner = new Liner(rows);
        liner.draw(row,col);
    }

    public int run(int stratCol) {
        Runner runner = new Runner(rows);
        return runner.run(stratCol);
    }
}
