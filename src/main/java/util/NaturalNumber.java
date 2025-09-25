package util;

public class NaturalNumber {
    private int number;

    public int getNumber() {
        return number;
    }

    public static NaturalNumber from(int number) {
        return new NaturalNumber(number);
    }

    private NaturalNumber(int number) {
        if(number < 0){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NATURAL_NUMBER.getMessage());
        }
        this.number = number;
    }

    public void prev() {
        number--;
    }

    public void next() {
        number++;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
