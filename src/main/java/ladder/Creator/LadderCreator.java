package ladder.Creator;
import ladder.Position;
import ladder.Row;


public interface LadderCreator {
    Row[] getRows();
    void drawLine(Position row, Position col);

}
