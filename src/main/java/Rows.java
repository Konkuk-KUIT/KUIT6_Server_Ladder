// 줄의 위치를 저장하는 객체
public class Rows {
    private final int[][] rows;

    public Rows(int row, int numberOfPerson) {
        this.rows = new int[row][numberOfPerson - 1];
    }

    // 사다리 라인 만들때 같은 행에 이미 값이 있으면 넣지 못하도록 해야할듯

    public void drawLine(int x, int y) {
        rows[x][y] = 1;
    }

    public int[][] getRows() {
        return rows;
    }

    public static Rows from(int row, int numberOfPerson) {
        return new Rows(row, numberOfPerson);
    }

    public int getValue(int x, int y) {
        return rows[x][y];
    }
}
