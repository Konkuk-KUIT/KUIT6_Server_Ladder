public class Ladder {

    private final int[][] rows;
    private final int numberOfPersons;
    private final LadderGame game; // 게임과 연결

    public Ladder(NaturalNumber rowCount, NaturalNumber numberOfPersons) {
        this.numberOfPersons = numberOfPersons.value();
        this.rows = new int[rowCount.value()][numberOfPersons.value()];
        this.game = new LadderGame(this);
    }

    public void drawLine(NaturalNumber row, NaturalNumber person) {
        int r = row.value() - 1;
        int p = person.value() - 1;

        rows[r][p] = 1;
        rows[r][p + 1] = -1;
    }

    public NaturalNumber run(NaturalNumber start) {
        return game.play(start);
    }

    public int[][] getRows() {
        return rows;
    }

    public NaturalNumber getNumberOfPersons() {
        return new NaturalNumber(numberOfPersons);
    }
}
