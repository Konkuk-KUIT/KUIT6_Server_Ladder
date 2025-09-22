package runner;

import ladderboard.board.Board;
import position.Position;
import wrap.StartPosition;

public interface GameRunner {
    Position run(Board board, StartPosition startPosition);
}