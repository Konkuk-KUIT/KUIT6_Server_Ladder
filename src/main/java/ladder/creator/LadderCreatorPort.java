package ladder.creator;
import ladder.position.Position;
import ladder.core.Row;

public interface LadderCreatorPort {
    void drawLine(Position row, Position col); // (row, col)~(row, col+1)
    Row[] getRows();
    int getNumberOfPerson();
}
