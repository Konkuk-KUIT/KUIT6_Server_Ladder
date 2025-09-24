public class NaturalNum {
    private int naturalNum;

    private NaturalNum(int naturalNum) {
        if(naturalNum < 0) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_NATURE_NUMBER.getMessage());
        }
        this.naturalNum = naturalNum;
    }
    public static NaturalNum of(int n) {
        return new NaturalNum(n);
    }

    public int getNaturalNum() {
        return naturalNum;
    }

}
