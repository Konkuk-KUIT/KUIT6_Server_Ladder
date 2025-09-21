package domain;

public class Ladder {
    private final Row[] rows;
    private final Liner liner;

    private Ladder(int row, int numberOfPerson, Liner liner) {
        this.liner = liner;
        rows = Row.makeInitRows(row, numberOfPerson);
    }

    public static Ladder from(Liner liner) {
        return new Ladder(liner.getRow(), liner.getNumberOfPerson(), liner);
    }

    public void drawLine(int left, int right, int height) {
        liner.drawLine(left, right, height, this.rows);
    }

    public Row[] getRows() {
        return rows;
    }
}
