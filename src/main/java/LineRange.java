public class LineRange {
    private NaturalNumber range;

    private LineRange(NaturalNumber range) {
        this.range = range;
    }

    public boolean contains(NaturalNumber position) {
        return position.getNumber() < range.getNumber();
    }

    public static LineRange getInstance(NaturalNumber range) {
        return new LineRange(range);
    }

    public NaturalNumber getRange() {
        return range;
    }
}
