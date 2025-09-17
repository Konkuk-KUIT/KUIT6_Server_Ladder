import java.util.Random;

public interface DrawLineStrategy {
    default void drawLine(LineNumber position,  LadderBoard ladderBoard) {
        int startPosition = position.getNumber();
        int endIndex = ladderBoard.cols();

        for(int i = 0; i < endIndex; i++){

            createBridge(i, startPosition, ladderBoard);

        }
    }

    void createBridge(int i, int startPosition, LadderBoard ladderBoard);

    default void randomCreateBridge(int row, int col, LadderBoard ladderBoard, Random random) {
        if(random.nextBoolean()) {
            leftCreateBridge(row, col, ladderBoard);
            return;
        }
        rightCreateBridge(row, col, ladderBoard);
    }

    default void leftCreateBridge(int row, int col, LadderBoard ladderBoard) {
        if(ladderBoard.get(row, col-1) != 0){
            return;
        }
        ladderBoard.set(row, col, -1);
        ladderBoard.set(row, col-1, 1);

    }

    default void rightCreateBridge(int row, int col, LadderBoard ladderBoard) {
        if(ladderBoard.get(row, col+1) != 0){
            return;
        }
        ladderBoard.set(row, col, 1);
        ladderBoard.set(row, col+1, -1);
    }
}
