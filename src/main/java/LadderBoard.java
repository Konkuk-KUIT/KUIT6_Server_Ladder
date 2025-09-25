import java.util.Random;

public final class LadderBoard {
    //    private final int[][] grid;
    private Row[] rows;
    private LineRange range;

    public LadderBoard(NaturalNumber rows, NaturalNumber cols) {
        this.rows = new Row[rows.getNumber()];
        for (int i = 0; i < cols.getNumber(); i++) {
            this.rows[i] = new Row(cols);
        }
        this.range = LineRange.getInstance(cols);
    }

    public Row[] getRows() {
        return rows;
    }

    public int rows() {
        return rows.length;
    }

    public int cols() {
        return range.getRange().getNumber();
    }

    public void createRightBridge(int r, int c) {
        rows[r].createRightBridge(c);
    }

    public void run(LineNumber position){
        for (Row row : rows) {
            row.run(position);
        }
        System.out.println(position);
    }


    // test 전용
    public void printGrid() {
        for (Row row : rows) {
            row.printRow();
        }

    }


}