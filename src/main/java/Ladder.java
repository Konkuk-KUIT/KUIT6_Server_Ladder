public class Ladder {

    private final int[][] rows;
    private final int players;
    private final int height;

    public Ladder(int players, int height) {
        this.players = players;
        this.height = height;
        this.rows = new int[height][players - 1];
    }

    public void drawLine(int row, int col) {
        inspectLine(row, col);
        rows[row][col] = 1;
    }

    public int run(int startLine) {
        inspectPosition(startLine);
        int position = startLine - 1;
        for (int row = 0; row < height; row++) {
            position = move(position, row);
        }
        return position + 1;
    }

    private int move(int position, int row) {
        if (position > 0 && rows[row][position - 1] == 1) {
            return position - 1;
        }
        if (position < players - 1 && rows[row][position] == 1) {
            return position + 1;
        }
        return position;
    }

    private void inspectPosition(int startPosition) {
        if (startPosition < 1 || startPosition > players) {
            throw new IllegalArgumentException("시작 위치가 옳지 않습니다.");
        }
    }

    private void inspectLine(int row, int col) {
        if (row < 0 || row >= height) {
            throw new IllegalArgumentException("row 값이 범위에 맞지 않습니다.");
        }
        if (col < 0 || col >= players - 1) {
            throw new IllegalArgumentException("col 값이 범위에 맞지 않습니다.");
        }

        // 연속적 라인 왼오 예외처리
        if (col > 0 && rows[row][col - 1] == 1) {
            throw new IllegalArgumentException("같은 높이에서 연속적인 선은 만들 수 없습니다.");
        }

        if (col < players - 2 && rows[row][col + 1] == 1) {
            throw new IllegalArgumentException("같은 높이에서 연속적인 선은 만들 수 없습니다.");
        }
    }

    //////-------------------print-------------------/////
    public void printLines() {
        for (int row = 0; row < height; row++) {
            printRow(row);
            System.out.println();
        }
    }

    private void printRow(int row) {
        for (int col = 0; col < players - 1; col++) {
            printEach(row, col);
        }
    }

    private void printEach(int row, int col) {
        System.out.print("|");
        String line = "   ";
        if (rows[row][col] == 1) {
            line = "---";
        }
        System.out.print(line);
        if (col == players - 2) {
            System.out.print("|");
        }
    }
}

