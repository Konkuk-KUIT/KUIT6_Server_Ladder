public class NaturalNumber {
    private int number;

    //정적팩토리 메소드
    public static NaturalNumber from(int number) {
        return new NaturalNumber(number);
    }

    private NaturalNumber(int number) {
        if(number < 1){
            throw new IllegalArgumentException("1보다 작으면 안됨");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
