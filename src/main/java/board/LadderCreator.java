package board;

import position.Coordinate;
import wrap.PersonCount;
import wrap.LadderHeight;

public class LadderCreator implements Board {
    
    private final LadderBoard ladderBoard;
    
    public LadderCreator(PersonCount personCount, LadderHeight ladderHeight) {
        this.ladderBoard = new LadderBoard(personCount, ladderHeight);
    }
    
    public void drawLine(Coordinate coordinate) {
        ladderBoard.drawLine(coordinate);
    }
    
    public boolean hasConnection(Coordinate coordinate) {
        return ladderBoard.hasConnection(coordinate);
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