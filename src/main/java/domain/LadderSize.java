package domain;

public class LadderSize {
    private final int numberOfRow;
    private final int numberOfPerson;

    public LadderSize(int numberOfRow, int numberOfPerson) {
        if (numberOfRow < 1) {
            throw new IllegalArgumentException("사다리 행은 1 이상이어야 합니다.");
        }
        if (numberOfPerson < 2) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public int numberOfRow() {
        return numberOfRow;
    }

    public int numberOfPerson() {
        return numberOfPerson;
    }

    public int calculateLineCount() {
        return (int) (numberOfRow * numberOfPerson * 0.3);
    }

    @Override
    public String toString() {
        return "domain.LadderSize{" +
                "rows=" + numberOfRow +
                ", persons=" + numberOfPerson +
                ", lineCount=" + calculateLineCount() +
                '}';
    }
}
