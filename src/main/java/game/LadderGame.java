package game;

import board.Board;
import position.Coordinate;
import position.Position;
import runner.GameRunner;
import wrap.StartPosition;

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
    
    public Position run(StartPosition startPosition) {
        return runner.run(board, startPosition);
    }

    public Board getBoard() {
        return board;
    }
    
    public GameRunner getRunner() {
        return runner;
    }
}
