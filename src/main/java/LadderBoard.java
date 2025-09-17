public final class LadderBoard {
    private final int[][] grid;

    public LadderBoard(NaturalNumber rows, NaturalNumber cols) {
        this.grid = new int[rows.getNumber()][cols.getNumber()];
    }

    public int rows() { return grid.length; }
    public int cols() { return grid[0].length; }

    public int get(int r, int c) { return grid[r][c]; }
    public void set(int r, int c, int v) { grid[r][c] = v; }

    public int checkBoard(int row, int col) {

        if(grid[row][col] == 1){
            return ++col;
        }

        if(grid[row][col] == -1){
            return --col;
        }

        return col;
    }

    public void printGrid(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}