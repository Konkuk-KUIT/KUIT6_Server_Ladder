public class Position {
    private NoneNegative height;
    private NoneNegative row;
    private boolean isToLeft;

    public Position(NoneNegative height, NoneNegative row){
        this.height = height;
        this.row = row;
        this.isToLeft = false;
    }
    public Position(NoneNegative height, NoneNegative row, boolean isToLeft){
        this.height = height;
        this.row = row;
        this.isToLeft = isToLeft;
    }

    public NoneNegative getHeight(){
        return height;
    }
    public NoneNegative getRow(){
        return row;
    }
    public boolean getIsToLeft(){
        return isToLeft;
    }
}
