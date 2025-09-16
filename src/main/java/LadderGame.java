import validator.LadderNumberValidator;

public class LadderGame {
    private final int row;
    private final int numberOfPerson;
    private final int[][] rows;

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
        this.row = ladder.getRow();
        this.rows = ladder.getRows();
        this.numberOfPerson = ladder.getNumberOfPerson();
    }

    public int run(int ladderNum){
        LadderNumberValidator.validateLadderNumber(ladderNum, numberOfPerson);
        int col = ladderNum - 1;
        for (int height = 0; height < row; height++) {
            col += rows[height][col];
        }
        return col + 1;
    }

}
