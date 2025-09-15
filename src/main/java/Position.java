public class Position {
    private int height;
    private int row;
    private boolean isToLeft;

    public Position(int height, int row){
        this.height = height;
        this.row = row;
        this.isToLeft = false;
    }
    public Position(int height, int row, boolean isToLeft){
        this.height = height;
        this.row = row;
        this.isToLeft = isToLeft;
    }

    public int getHeight(){
        return height;
    }
    public int getRow(){
        return row;
    }
    public boolean getIsToLeft(){
        return isToLeft;
    }
}
