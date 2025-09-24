package laddercreator;

import board.Board;
import board.LadderBoard;
import board.LineDirection;
import board.Row;
import position.Coordinate;
import wrap.PersonCount;
import wrap.LadderHeight;

public class NormalLadderCreator implements Board {
    
    private final LadderBoard ladderBoard;
    
    public NormalLadderCreator(PersonCount personCount, LadderHeight ladderHeight) {
        this.ladderBoard = new LadderBoard(personCount, ladderHeight);
    }
    
    public void drawLine(Coordinate coordinate) {
        ladderBoard.drawLine(coordinate);
    }
    
    public boolean hasConnection(Coordinate coordinate) {
        return ladderBoard.hasConnection(coordinate);
    }
    
    public LineDirection getLineDirection(Coordinate coordinate) {
        return ladderBoard.getLineDirection(coordinate);
    }

    public int getHeight() {
        return ladderBoard.getHeight();
    }

    public int getNumberOfPerson() {
        return ladderBoard.getNumberOfPerson();
    }
    
    public Row[] getRows() {
        return ladderBoard.getRows();
    }
}