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
}
