// 줄의 위치를 저장하는 객체
public class StringArray {
    private int[][] stringArray;

    public StringArray(int row, int numberOfPerson) {
        this.stringArray = new int[row][numberOfPerson - 1]; // 줄의 수는 사람 수보다 1 적음
    }

    public int getRowsLength() {
        return stringArray.length;
    }

    public int getColumnsLength() {
        return stringArray[0].length;
    }

    public int getValue(int row, int column) {
        return stringArray[row][column];
    }

    public void setValue(int row, int column) {
        if (row < 0 || row >= stringArray.length || column < 0 || column >= stringArray[0].length) {
            throw new IllegalArgumentException("올바른 범위의 줄의 위치가 아닙니다");
        }
        for (int i = 0; i < stringArray[row].length; i++) {
            if (i == column) {
                continue;
            }
            if (stringArray[row][i] == 1) {
                throw new IllegalArgumentException("이미 사용중인 줄입니다.");
            }
        }
        stringArray[row][column] = 1;
    }
}
