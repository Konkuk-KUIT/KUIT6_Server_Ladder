public class LadderSize {
    private GreaterThanOne row;
    private GreaterThanOne numberOfPerson;

    public LadderSize(GreaterThanOne row, GreaterThanOne numberOfPerson) {
        this.row = row;
        this.numberOfPerson = numberOfPerson;
    }

    public static LadderSize from(GreaterThanOne row, GreaterThanOne numberOfPerson){
        return new LadderSize(row, numberOfPerson);
    }

    public GreaterThanOne getRow() {
        return row;
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }
}
