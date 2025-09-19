package runner;

import board.Board;

public interface GameRunner {
    int run(Board board, int startPosition);
}