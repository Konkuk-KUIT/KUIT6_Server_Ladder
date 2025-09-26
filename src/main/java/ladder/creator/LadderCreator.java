package ladder.creator;

import ladder.domain.LadderPosition;
import ladder.validator.GreaterThanOne;
import ladder.domain.Position;
import ladder.domain.Row;

public interface LadderCreator {
    Row[] getRows();

    void drawLine(LadderPosition position);
}