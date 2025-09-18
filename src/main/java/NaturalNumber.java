public class NaturalNumber
{
    private int number;

    public int getNumber()
    {
        return number;
    }

    public static NaturalNumber from(int number) {
        return new NaturalNumber(number);
    }

    public NaturalNumber(int number) {
        if(number < 0) throw new IllegalArgumentException("해당 숫자는 자연수가 아닙니다.");

        this.number = number;
    }

}
