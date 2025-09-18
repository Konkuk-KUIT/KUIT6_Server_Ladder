public final class LadderBoard {
    private final int[][] grid;

    public LadderBoard(NaturalNumber rows, NaturalNumber cols) {
        this.grid = new int[rows.getNumber()][cols.getNumber()];
    }

    public int rows() { return grid.length; }
    public int cols() { return grid[0].length; }

    public boolean isNotZero(int r, int c) { return grid[r][c] != 0; }
    public void createLeftBridge(int r, int c){
        grid[r][c] = -1;
        grid[r][c-1] = 1;
    }
    public void createRightBridge(int r, int c){
        grid[r][c] = 1;
        grid[r][c+1] = -1;
    }

    public int checkBoard(int row, int col) {

        if(grid[row][col] == 1){
            return ++col;
        }

        if(grid[row][col] == -1){
            return --col;
        }

        return col;
    }

    // test 전용
    public void printGrid(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}