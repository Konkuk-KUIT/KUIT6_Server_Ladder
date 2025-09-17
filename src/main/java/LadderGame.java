import validator.LadderNumberValidator;

public class LadderGame {
    private final int row;
    private final int numberOfPerson;
    private final int[][] rows;

    private LadderGame(int row, int[][] rows, int numberOfPerson) {
        this.row = row;
        this.rows = rows;
        this.numberOfPerson = numberOfPerson;
    }

    public static LadderGame of(Ladder ladder, Liner liner) {
        return new LadderGame(liner.getRow(), ladder.getRows(), liner.getNumberOfPerson());
    }

    public int run(int ladderNum) {
        LadderNumberValidator.validateLadderNumber(ladderNum, numberOfPerson);
        int col = ladderNum - 1;
        for (int height = 0; height < row; height++) {
            col += rows[height][col];
        }
        return col + 1;
    }

}
