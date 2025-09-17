public class Ladder {

    private final int[][] rows;
    private final int numberOfPerson;
    private final int row;

    // row, numberOfPerson  >0
    public Ladder(int row, int numberOfPerson) {
        if(row<1 && numberOfPerson<1){
            throw new IllegalArgumentException("Invalid Ladder Create Input - negative not allowed");
        }
        this.numberOfPerson = numberOfPerson;
        this.row = row;
        rows = new int[row][numberOfPerson];
    }

    // row, col 에서 우측으로 Line 생성
    // 0<= row < this.row
    // 0<= col < numberOfPerson-1
    public void drawline(int row, int col){
        if (row<0 || col<0 || row>=this.row || col>=this.numberOfPerson-1){
            throw new IllegalArgumentException("Invalid Ladder Draw Input - out of bounds");
        }
        if(rows[row][col]!=0 || rows[row][col+1]!=0){
            throw new IllegalArgumentException("Invalid Ladder Draw Input - already exists");
        }
        drawlineValid(row, col);
    }

    private void drawlineValid(int row, int col){
        rows[row][col]++;
        rows[row][col+1]--;
    }

    public int run(int col){
        if(col<0 || col>=this.numberOfPerson){
            throw new IllegalArgumentException("Invalid Ladder Run Input - out of bounds");
        }
        int currentCol = col;
        for (int height=0; height<this.row; height++){
            currentCol += rows[height][currentCol];
        }

        return currentCol;
    }
}
