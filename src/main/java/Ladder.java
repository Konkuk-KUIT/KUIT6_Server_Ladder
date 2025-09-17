import java.util.Arrays;

public class Ladder {
    
    private StringArray stringArray;

    public Ladder(int row, int numberOfPerson) {
        this.stringArray = new StringArray(row, numberOfPerson);
    }

    public StringArray getStringArray() {
        return stringArray;
    }

    public void drawLine(int row, int column) {
        stringArray.setValue(row, column);
    }

    public int run(int number) {
        if (number < 0 || number >= stringArray.getColumnsLength()) {
            throw new IllegalArgumentException("사다리 번호는 1부터 사람수 사이의 숫자만 가능합니다.");
        }

        int[] curPos = new int[]{0, number}; //[행, 현재 열의 위치]

        for (int i = 0; i < stringArray.getRowsLength(); i++) {
            if (curPos[1] == 0) {
                // 첫 열인 경우
                if (stringArray.getValue(i, curPos[1]) == 1) {
                    curPos[1] = 1;
                }
            } else if (curPos[1] != 0 && curPos[1] != stringArray.getColumnsLength()) {
                // 첫 열과 마지막 열 사이인 경우
                if (stringArray.getValue(i, curPos[1] - 1) == 1) {
                    curPos[1] -= 1;
                } else if (stringArray.getValue(i, curPos[1]) == 1) {
                    curPos[1] += 1;
                }
            } else if (curPos[1] == stringArray.getColumnsLength()) {
                // 마지막 열인 경우
                if (stringArray.getValue(i, curPos[1] - 1) == 1) {
                    curPos[1] -= 1;
                }
            }
            curPos[0] = i + 1;
            System.out.println(Arrays.toString(curPos));

        }

        return curPos[1];
    }
}
