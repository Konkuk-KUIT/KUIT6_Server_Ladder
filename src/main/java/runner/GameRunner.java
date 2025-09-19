package runner;

import ladderboard.board.Board;

public interface GameRunner {
    int run(Board board, int startPosition);
}