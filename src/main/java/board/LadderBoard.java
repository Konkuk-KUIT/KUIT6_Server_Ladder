package board;

import exceptions.InvalidCoordinateException;
import exceptions.ErrorMessage;
import position.Coordinate;
import position.Position;
import wrap.PersonCount;
import wrap.LadderHeight;
import wrap.NodeIndex;

public class LadderBoard implements Board {
    
    private final Row[] rows;
    private final PersonCount personCount;
    private final LadderHeight ladderHeight;
    
    public LadderBoard(PersonCount personCount, LadderHeight ladderHeight) {
        this.personCount = personCount;
        this.ladderHeight = ladderHeight;
        this.rows = new Row[ladderHeight.getValue()];
        initializeRows();
    }
    
    private void initializeRows() {
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row(personCount, i);
        }
    }
    
    public void drawLine(Coordinate coordinate) {
        validateCoordinateRange(coordinate);
        
        int y = coordinate.getY();
        int x = coordinate.getX();
        rows[y].connectNode(NodeIndex.at(x));
    }
    
    public boolean hasConnection(Coordinate coordinate) {
        int y = coordinate.getY();
        int x = coordinate.getX();
        
        if (ladderHeight.isValidRow(y) || personCount.isValidLineIndex(x)) {
            return false;
        }
        return rows[y].hasConnection(NodeIndex.at(x));
    }
    
    public LineDirection getLineDirection(Coordinate coordinate) {
        // 해당 위치에서 오른쪽으로 가는 선이 있으면
        if (hasConnection(coordinate)) {
            return LineDirection.RIGHT;
        }
        
        // 왼쪽에서 오는 선이 있는지 확인
        int x = coordinate.getX();
        if (x > 0) {
            Coordinate leftCoord = Position.at(coordinate.getY(), x - 1);
            if (hasConnection(leftCoord)) {
                return LineDirection.LEFT;
            }
        }
        
        return LineDirection.NONE;
    }
    
    public int getHeight() {
        return ladderHeight.getValue();
    }
    
    public int getNumberOfPerson() {
        return personCount.getValue();
    }
    
    public Row[] getRows() {
        return rows;
    }
    
    private void validateCoordinateRange(Coordinate coordinate) {
        if (coordinate == null) {
            throw new InvalidCoordinateException(ErrorMessage.NULL_COORDINATE.getMessage());
        }

        int y = coordinate.getY();
        int x = coordinate.getX();

        if (ladderHeight.isValidRow(y)) {
            throw new InvalidCoordinateException(ErrorMessage.INVALID_COORDINATE_Y.format(y, ladderHeight.getValue()-1));
        }

        if (personCount.isValidLineIndex(x)) {
            throw new InvalidCoordinateException(ErrorMessage.INVALID_COORDINATE_X.format(x, personCount.getMaxLineIndex()));
        }
    }
}