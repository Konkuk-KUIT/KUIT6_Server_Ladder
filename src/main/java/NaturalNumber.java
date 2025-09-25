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
        if(number <= 0) throw new IllegalArgumentException(ExceptionMessages.INVALID_NATURAL_NUMBER.getMessage());

        this.number = number;
    }

}
