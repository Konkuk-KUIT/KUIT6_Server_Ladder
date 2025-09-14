import java.util.Arrays;

public class Ladder {

    private final int[][] rows; // 줄의 위치를 저장하는 배열

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson - 1];
    }

    public int[][] getRows() {
        return rows;
    }

    public void drawLine(int x, int y) {
        rows[x][y] = 1;
    }

    public int run(int number) {
        if (number < 0 || number >= rows[0].length) {
            throw new IllegalArgumentException("사다리 번호는 1부터 사람수 사이의 숫자만 가능합니다.");
        }

        int[] curPos = new int[]{0, number}; //[행, 현재 열의 위치]

        for (int i = 0; i < rows.length; i++) {
            if (curPos[1] == 0) {
                // 첫 열인 경우
                if (rows[i][curPos[1]] == 1) {
                    curPos[1] = 1;
                }
            } else if (curPos[1] != 0 && curPos[1] != rows[0].length) {
                // 첫 열과 마지막 열 사이인 경우
                if (rows[i][curPos[1] - 1] == 1) {
                    curPos[1] -= 1;
                } else if (rows[i][curPos[1]] == 1) {
                    curPos[1] += 1;
                }
            } else if (curPos[1] == rows[0].length) {
                if (rows[i][curPos[1] - 1] == 1) {
                    curPos[1] -= 1;
                }
            }
            curPos[0] = i + 1;
            System.out.println(Arrays.toString(curPos));

        }

        return curPos[1];
    }
}
