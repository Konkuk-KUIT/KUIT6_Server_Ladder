// 줄의 위치를 저장하는 객체
public class StringArray {
    private int[][] stringArray;

    public StringArray(int row, int numberOfPerson) {
        this.stringArray = new int[row][numberOfPerson - 1]; // 줄의 수는 사람 수보다 1 적음
    }

    public int[][] getStringArray() {
        return stringArray;
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
        stringArray[row][column] = 1;
    }
}
