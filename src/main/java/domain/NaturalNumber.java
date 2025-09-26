package domain;

public class NaturalNumber {
    private final int value;

    //원시값 포장+자연수만 사용
    public NaturalNumber(int value) {
        if(value <= 0) { throw new IllegalArgumentException("1 이상 입력해주세요.");}
        this.value = value;
    }
    public int value() {
        return value;
    }

    //오른쪽 이동시 +1 > position에서 사용
    public NaturalNumber add(int delta) {
        return new NaturalNumber(value + delta);
    }

    //왼쪽 이동시 -1 > position에서 사용
    public NaturalNumber subtract(int delta) {
        return new NaturalNumber(value - delta);
    }

}
