public class NoneNegative {
    private int number;

    private NoneNegative(int number) {
        if(number < 0) throw new IllegalArgumentException();
        this.number = number;
    }

    public static NoneNegative from(int number){
        return new NoneNegative(number);
    }

    public int getNumber(){
        return number;
    }
}
