public class LineRange {
    private NaturalNumber range;

    public LineRange(NaturalNumber range) {
        this.range = range;
    }

    public boolean contains(NaturalNumber position) {
        return position.getNumber() < range.getNumber();
    }

    public NaturalNumber getRange() {
        return range;
    }
}
