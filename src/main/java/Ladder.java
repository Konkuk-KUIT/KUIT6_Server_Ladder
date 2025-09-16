public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        row--;
        numberOfPerson--;
        rows = new int[row][numberOfPerson];
    }

    //  같은 높이에 연속된 사다리 존재x
    public void drawLine(int row, int col) {
        if (col < 0 &&rows[row][col + 1] == 1) { //인덱스 예외 나오나?
            throw new IllegalArgumentException("같은 높이에서 연속된 선 불가능");
        }
        if (col > rows[0].length && rows[row][col - 1] == 1) {
            throw new IllegalArgumentException("같은 높이에서 연속된 선 불가능");
        }
        if (rows[row][col] == 1) {
            throw new IllegalArgumentException("중복된 선");
        }
        rows[row][col] = 1;
    }

    public int run(int col) {
        //진행 위치
        int height = 0;
        int colPosition = col-1; //0-base

        while (height < rows.length) {
            if (colPosition > 0 && rows[height][colPosition - 1] == 1) {
                colPosition--;
            }
            if (colPosition + 1 < rows[0].length && rows[height][colPosition + 1] == 1) {
                colPosition++;
            }
            height++;
        }
        return ++colPosition; //1-base
    }

//    public void printLadder() {
//        for (int i = 0; i < rows.length; i++) {
//            for (int j = 0; j < rows[0].length; j++) {
//                System.out.print(rows[i][j]+"\t");
//            }
//            System.out.println();
//        }
//    }

}
