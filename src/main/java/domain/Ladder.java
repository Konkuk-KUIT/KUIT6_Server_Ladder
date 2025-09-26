package domain;

public class Ladder {
    private final Row[] rows;
    private final int numberOfPersons;

    public Ladder(LadderSize size, Row[] rows) {
        this.numberOfPersons = size.numberOfPerson();
        this.rows = rows;
    }

    public Row[] getRowObjects() {
        return rows;
    }

    public NaturalNumber getNumberOfPersons() {
        return new NaturalNumber(numberOfPersons);
    }
}
