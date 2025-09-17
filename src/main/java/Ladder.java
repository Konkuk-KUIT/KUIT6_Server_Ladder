public class Ladder {
    private final int row;
    private final int numberOfPerson;
    private final int[][] rows;
    private final Liner liner;

    private Ladder(int row, int numberOfPerson, Liner liner) {
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        this.liner = liner;
        rows = new int[row][numberOfPerson];
    }

    public static Ladder from(Liner liner){
        return new Ladder(liner.getRow(),liner.getNumberOfPerson(),liner);
    }

    public void drawLine(int left, int right, int height) {
        liner.drawLine(left, right, height, this.rows);
    }

    public int getRow() {
        return row;
    }

    public int[][] getRows() {
        return rows;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }
}
