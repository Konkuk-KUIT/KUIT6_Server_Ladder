package ladder;

public class GreaterThanOne {

    private final int number;

    private GreaterThanOne(int number) {
        validate(number);
        this.number = number;
    }

    public static GreaterThanOne from(int number) {
        return new GreaterThanOne(number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if(number <= 1){
                throw new IllegalArgumentException(ErrorMessage.INVALID_GREATER_THAN_ONE.getMessage());
        }
    }
}
