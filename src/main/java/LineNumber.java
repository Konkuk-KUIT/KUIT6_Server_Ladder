public class LineNumber {
    private NaturalNumber number;
    private LineRange range;

    private LineNumber(NaturalNumber number, LineRange range) {
        if(!range.contains(number)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LINE_NUMBER.getMessage());
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
        if(number.getNumber() == range.getRange().getNumber()-1 ) {
            return DrawLineStrategyType.RIGHT;
        }
        return DrawLineStrategyType.NORMAL;
    }

    public void goLeft(){
        number.prev();
    }

    public void goRight() {
        number.next();
    }

    @Override
    public String toString() {
        return number.toString();
    }
}

