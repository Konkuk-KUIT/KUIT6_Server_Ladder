import board.LadderBoard;
import position.Coordinate;
import runner.GameRunner;

public class LadderGame {

    private final LadderBoard ladderBoard;
    private final GameRunner runner;

    public LadderGame(LadderBoard ladderBoard, GameRunner runner) {
        this.ladderBoard = ladderBoard;
        this.runner = runner;
    }
    
    public void drawLine(Coordinate coordinate) {
        ladderBoard.drawLine(coordinate);
    }
    
    public int run(int startPosition) {
        return runner.run(ladderBoard, startPosition);
    }
}
