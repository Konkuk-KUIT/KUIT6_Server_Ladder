public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson]; // row : 가로줄 수 numberOfPerson : 세로줄 수
    }

    private void validatePosition(Position position) {
        int row = position.getRow();
        int col = position.getCol();

        if (row == rows.length - 1) {
            throw new IllegalArgumentException("마지막 줄에서는 가로줄을 그을 수 없습니다.");
        }
        if (col == rows[0].length - 1) {
            throw new IllegalArgumentException("오른쪽에 선을 그을 수 없습니다.");
        }
        if (rows[row][col] == 1) {
            throw new IllegalArgumentException("해당 위치에 이미 가로선이 존재합니다.");
        }
        if ((col > 0 && rows[row][col - 1] == 1) ||
                (col + 1 < rows[0].length && rows[row][col + 1] == 1)) {
            throw new IllegalArgumentException("가로선은 연속으로 그릴 수 없습니다.");
        }
    }

    public void drawLine(Position position) { // 해당 위치에서 오른쪽으로만 선을 그을 수 있다.
        validatePosition(position);

        rows[position.getRow()][position.getCol()] = 1;
        rows[position.getRow()][position.getCol() + 1] = -1;

    }

    public int run(int startCol) {
        int startRow = 0;
        while (isEndLadder(startRow)) {
            if (rows[startRow][startCol] == 1) {
                startRow++;
                startCol++;
                continue;
            }
            if (rows[startRow][startCol] == -1) {
                startRow++;
                startCol--;
                continue;
            }
            if (rows[startRow][startCol] == 0) {
                startRow++;

            }
        }
        return startCol;
    }

    public boolean isEndLadder(int row) {
        return row < this.rows.length;
    }
}
