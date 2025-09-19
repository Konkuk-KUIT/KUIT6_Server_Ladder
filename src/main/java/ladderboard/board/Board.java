package ladderboard.board;

import position.Coordinate;

public interface Board {
    void drawLine(Coordinate coordinate);
    boolean hasConnection(Coordinate coordinate);
    int getHeight();
    int getNumberOfPerson();
}