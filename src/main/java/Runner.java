public class Runner {
    private final int[][] rows;

    public Runner(int[][] rows) {
        this.rows = rows;
    }

    public int run(int startCol) {
        //진행 위치
        int height = 0;
        int colPosition = startCol-1; //0-base


        while (height < rows.length) {
            if (colPosition > 0 && rows[height][colPosition - 1] == 1) {
                colPosition--;
            } else if (colPosition < rows[0].length && rows[height][colPosition] == 1) {
                colPosition++;
            }
            height++;
        }
        return ++colPosition; //1-base
    }
}
