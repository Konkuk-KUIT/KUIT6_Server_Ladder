public class Lines {
    private int[][] map;

    public Lines(int row, int col) {
        map = new int[row][col];
    }

    public int getCellValue(int row, int col){
        return map[row][col];
    }

    // empty면 1, not empty면 0
    public boolean isCellEmpty(int row, int col){
        return map[row][col] == 0;
    }

    public boolean isDrawPossible(int col1, int col2, int row){
        return isCellEmpty(row, col2) && isCellEmpty(row, col2);
    }


    // 새로운 map 만들어서 return 시키기
    public void addLine(int col1, int col2, int row){
        if(!isDrawPossible(col1, col2, row)){
            throw new IllegalArgumentException();
        }
        map[row][col1] = col2;
        map[row][col2] = col1;
    }
}
