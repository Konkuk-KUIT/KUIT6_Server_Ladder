public class Position {
    private int row;
    private int col;

    //constructor
    public Position(int row, int col) {
        if(row<0||col<0)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        this.row = row;
        this.col = col;
    }

    //getter
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isValid(int rowValue, int colValue){
        return this.row<=rowValue && this.col<=colValue;
    }
}
