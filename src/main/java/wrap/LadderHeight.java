package wrap;

public class LadderHeight {
    private final int value;

    public LadderHeight(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("사다리 높이는 0보다 커야 합니다");
        }
        this.value = value;
    }

    public boolean isValidRow(int row) {
        return row >= 0 && row < value;
    }
    
    public int getValue() {
        return value;
    }
}
