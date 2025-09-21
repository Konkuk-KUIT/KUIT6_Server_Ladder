package domain;

import validator.LadderNumberValidator;

public class LadderGame {
    private final int numberOfPerson;
    private final Row[] rows;

    private LadderGame(Row[] rows, int numberOfPerson) {
        this.rows = rows;
        this.numberOfPerson = numberOfPerson;
    }

    public static LadderGame of(Ladder ladder, Liner liner) {
        return new LadderGame(ladder.getRows(), liner.getNumberOfPerson());
    }

    public int run(int ladderNum) {
        LadderNumberValidator.validateLadderNumber(ladderNum, numberOfPerson);
        int col = ladderNum - 1;
        for (int height = 0; height < rows.length; height++) {
            col += rows[height].getNodeValue(col);
        }
        return col + 1;
    }

}
