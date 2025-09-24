public class GreaterThanOne {
    private final int value;

    private GreaterThanOne(int value){
        validateValue(value);
        this.value = value;
    }

    public static GreaterThanOne from (int value){
        return new GreaterThanOne(value);
    }

    private void validateValue(int value) {
        if(value <= 1){
            throw new IllegalArgumentException();
        }
    }

    public int getValue(){
        return value;
    }
}
