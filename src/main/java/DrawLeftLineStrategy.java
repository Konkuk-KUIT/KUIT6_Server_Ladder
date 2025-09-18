import java.util.Random;

public class DrawLeftLineStrategy implements DrawLineStrategy{


    public void createBridge(int row, int col, LadderBoard ladderBoard) {
        Random random = new Random();
        if(ladderBoard.isNotZero(row, col)){
            return;
        }

        if(random.nextInt(2) == 0){
            rightCreateBridge(row, col, ladderBoard);
        }
    }

}
