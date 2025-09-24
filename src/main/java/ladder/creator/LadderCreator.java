package ladder.creator;

import ladder.core.Row;
import ladder.position.LadderPosition;

public interface LadderCreator {
    void drawLine(LadderPosition ladderPosition);
    Row[] getRows();
}
