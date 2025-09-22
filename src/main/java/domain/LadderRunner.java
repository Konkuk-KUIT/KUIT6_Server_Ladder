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
        System.out.println(getLadderString());
        for (int height = 0; height < rows.length; height++) {
            System.out.println("Before");
            System.out.println(getLadderString(height, col));
            col += rows[height].getNodeValue(col);
            System.out.println("After");
            System.out.println(getLadderString(height, col));
        }
        return col + 1;
    }

    public String getLadderString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Row row : rows) {
            stringBuilder.append(row.toString());
        }
        return stringBuilder.toString();
    }

    public String getLadderString(int height, int col) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            stringBuilder.append(i != height ? rows[i].toString() : rows[i].getStringPoint(col));
        }
        return stringBuilder.toString();
    }
}
