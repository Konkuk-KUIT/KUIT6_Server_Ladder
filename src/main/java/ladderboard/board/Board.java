package ladderboard.board;

import ladderboard.LineDirection;
import position.Coordinate;

public interface Board {
    void drawLine(Coordinate coordinate);
    boolean hasConnection(Coordinate coordinate);
    LineDirection getLineDirection(Coordinate coordinate);
    int getHeight();
    int getNumberOfPerson();
}