public class NaturalNumber {
    public int number;

    public NaturalNumber(int number) {
        if(number <= 0) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public static NaturalNumber from(int number) {
        return new NaturalNumber(number);
    }

    public int getNumber() {
        return number;
    }
}
