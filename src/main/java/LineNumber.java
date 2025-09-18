public class LineNumber {
    private NaturalNumber number;
    private LineRange range;

    private LineNumber(NaturalNumber number, LineRange range) {
        if(!range.contains(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
        this.range = range;
    }

    public static LineNumber of(NaturalNumber number, LineRange range) {
        return new LineNumber(number, range);
    }

    public int getNumber() {
        return number.getNumber();

    }

    public DrawLineStrategyType getDrawLineStrategyType() {
        if (number.getNumber() == 0){
            return DrawLineStrategyType.LEFT; }

        if (number.getNumber() == range.getRange().getNumber()-1){
            return DrawLineStrategyType.RIGHT; }

        return DrawLineStrategyType.MIDDLE;
    }
}

