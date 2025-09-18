import java.util.Random;

public class DrawMiddleLineStrategy implements DrawLineStrategy{
    public void createBridge(int row, int col, LadderBoard ladderBoard) {
        Random random = new Random();
        if(ladderBoard.isNotZero(row, col+1)) {
            return;
        }

        if(random.nextInt(2) == 0){
            randomCreateBridge(row,col,ladderBoard, random);
        }
    }


}
