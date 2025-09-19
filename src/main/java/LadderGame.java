import board.Board;
import position.Coordinate;
import runner.GameRunner;

public class LadderGame {

    private final Board board;
    private final GameRunner runner;

    public LadderGame(Board board, GameRunner runner) {
        this.board = board;
        this.runner = runner;
    }
    
    public void drawLine(Coordinate coordinate) {
        board.drawLine(coordinate);
    }
    
    public int run(int startPosition) {
        return runner.run(board, startPosition);
    }
}
