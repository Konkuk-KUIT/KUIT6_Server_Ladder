package ladder;

public class LadderSize {
    private final GreaterThanOne numberOfRow;
    private final GreaterThanOne numberOfPerson;

    private LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public static LadderSize from(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        return new LadderSize(numberOfRow, numberOfPerson);
    }

    public GreaterThanOne getNumberOfRow() {
        return numberOfRow;
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }
}
