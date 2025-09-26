public class GreaterThanOne {
    private final int number;

    public GreaterThanOne(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if(number<1)
            throw new IllegalArgumentException("value must be at least 1");
    }
}
