package drawLineStrategy;

import domain.LadderBoard;
import game.LineNumber;

public interface DrawLineStrategy {
    void drawLine(LineNumber position, LadderBoard ladderBoard);
}
