package domain;

import validator.LadderNumberValidator;

public class LadderRunner {
    private final Row[] rows;
    private final int numberOfPerson;

    public LadderRunner(Row[] rows, int numberOfPerson) {
        this.rows = rows;
        this.numberOfPerson = numberOfPerson;
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
