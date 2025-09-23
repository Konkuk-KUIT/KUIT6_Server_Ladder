public class GreaterThanOne {

    private int num;

    private GreaterThanOne(int number) {
        validate(number);
        num = number;
    }

    private void validate(int number) {
        if (number <= 1) {
            throw new IllegalStateException(ErrorMessage.INVALID_GREATER_THAN_ONE.getMsg());
        }
    }

    public static GreaterThanOne from(int number) {
        return new GreaterThanOne(number);
    }

    public int getNum() {
        return num;
    }
}
