import java.util.Random;

public class DrawLeftLineStrategy implements DrawLineStrategy{


    public void createBridge(int row, int col, LadderBoard ladderBoard) {
        Random random = new Random();
        if(ladderBoard.get(row, col) != 0){
            return;
        }

        if(random.nextInt(2) == 0){
            rightCreateBridge(row, col, ladderBoard);
        }
    }

}
