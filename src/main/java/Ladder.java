public class Ladder {

    private Rows rows;

    private Ladder(Rows rows) {
        this.rows = rows;
    }

    public static Ladder createOneLineLadder(int numberOfPerson) {
        return new Ladder(new Rows(1, numberOfPerson));
    }

    public int getRows(int row, int numberOfPerson) {
        return rows.getRows(row, numberOfPerson);
    }

    public static Ladder createSeveralLineLadder(int row, int numberOfPerson) {
        return new Ladder(new Rows(row, numberOfPerson));
    }

    public int run(int postion) {
        for (int i = 0; i < rows.row(); i++) {
            postion += rows.getRows(i, postion);
        }
        return postion;
    }

    public void drawLine(int row, int position) {
        rows.drawLine(row, position);
    }
}
