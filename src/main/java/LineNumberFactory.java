public class LineNumberFactory {
    LineRange range;

    private LineNumberFactory(LineRange range) {
        this.range = range;
    }
    public LineNumber factory(int number) {
        return LineNumber.of(NaturalNumber.from(number), range);
    }

    public static LineNumberFactory getInstance (LineRange range) {
        return new LineNumberFactory(range);
    }

}
