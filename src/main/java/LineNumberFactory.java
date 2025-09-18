public class LineNumberFactory {
    LineRange range;

    public LineNumberFactory(LineRange range) {
        this.range = range;
    }
    public LineNumber Factory(int number) {

        return LineNumber.of(NaturalNumber.from(number), range);
    }


}
