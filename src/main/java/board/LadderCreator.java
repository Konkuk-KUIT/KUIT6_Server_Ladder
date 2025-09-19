package board;

import position.Coordinate;
import wrap.PersonCount;
import wrap.LadderHeight;

public class LadderCreator implements Board {
    
    private final LadderBoard ladderLadderBoard;
    
    public LadderCreator(PersonCount personCount, LadderHeight ladderHeight) {
        this.ladderLadderBoard = new LadderBoard(personCount, ladderHeight);
    }
    
    public void drawLine(Coordinate coordinate) {
        ladderLadderBoard.drawLine(coordinate);
    }
    
    public boolean hasConnection(Coordinate coordinate) {
        return ladderLadderBoard.hasConnection(coordinate);
    }

    
    public int getHeight() {
        return ladderLadderBoard.getHeight();
    }

    public int getNumberOfPerson() {
        return ladderLadderBoard.getNumberOfPerson();
    }
    
    public Row[] getRows() {
        return ladderLadderBoard.getRows();
    }
}