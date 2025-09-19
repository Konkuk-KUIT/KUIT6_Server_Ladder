package runner;

import board.LadderBoard;

public interface GameRunner {
    int run(LadderBoard ladderBoard, int startPosition);
}