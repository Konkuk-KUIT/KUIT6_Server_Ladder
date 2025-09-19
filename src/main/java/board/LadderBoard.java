package board;

import position.Coordinate;

public interface LadderBoard {
    void drawLine(Coordinate coordinate);
    boolean hasConnection(Coordinate coordinate);
    int getHeight();
    int getNumberOfPerson();
}