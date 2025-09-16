package wrap;

import exceptions.InvalidPersonCountException;

public class PersonCount {

    private final int value;

    public PersonCount(int value) {
        if (value <= 0) {
            throw new InvalidPersonCountException("사람의 수가 0 이하인 경우 게임 진행이 불가합니다");
        };
        this.value = value;
    }

    public int getMaxLineIndex() {
        return value - 1;
    }
    
    public boolean isValidStartPosition(int startPosition) {
        return startPosition >= 0 && startPosition < value;
    }
    
    public boolean isValidLineIndex(int lineIndex) {
        return lineIndex >= 0 && lineIndex < getMaxLineIndex();
    }
    
    public int getValue() {
        return value;
    }
}
