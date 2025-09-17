public class NaturalNumber {
    private final int number;

    public int getNumber() {
        return number;
    }

    public static NaturalNumber from(int number) {
        return new NaturalNumber(number);
    }

    private NaturalNumber(int number) {
        if(number < 0){
            throw new IllegalArgumentException("Negative values are not allowed");
        }
        this.number = number;
    }
}
