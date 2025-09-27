package ladder.Creator;

import ladder.Domain.Row;
import ladder.Domain.Position;

public interface LadderCreator {
    Row[] getRows();
    void drawLine(Position row, Position col);
}

