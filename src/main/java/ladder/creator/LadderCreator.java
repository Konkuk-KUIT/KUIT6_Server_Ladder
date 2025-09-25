package ladder.creator;

import ladder.model.Position;
import ladder.model.Row;

public interface LadderCreator {

    void drawLine(Position row, Position col);

    Row[] getRows();
}