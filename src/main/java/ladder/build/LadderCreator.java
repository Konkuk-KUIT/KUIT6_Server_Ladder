package ladder.build;

import ladder.domain.Position;
import ladder.domain.Row;

public interface LadderCreator {
    void drawLine(Position row, Position col);
    Row[] getRows();
}
