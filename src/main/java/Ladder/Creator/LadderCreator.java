package Ladder.Creator;
import Ladder.Core.Position;
import Ladder.Core.Row;

public interface LadderCreator {
    void drawLine(Position row, Position col);

    Row[] getRows();
}
