package board;

import exceptions.DuplicateLineException;
import exceptions.InvalidCoordinateException;
import exceptions.ErrorMessage;
import position.Coordinate;
import wrap.PersonCount;
import wrap.LadderHeight;

public class LadderCreator implements LadderBoard {
    
    private final int[][] rows;
    private final PersonCount personCount;
    private final LadderHeight ladderHeight;
    
    public LadderCreator(PersonCount personCount, LadderHeight ladderHeight) {
        this.personCount = personCount;
        this.ladderHeight = ladderHeight;
        this.rows = new int[ladderHeight.getValue()][personCount.getMaxLineIndex()];
    }
    
    public void drawLine(Coordinate coordinate) {
        validateCoordinateRange(coordinate);
        validateNoDuplicateLine(coordinate);
        rows[coordinate.getY()][coordinate.getX()] = 1;
    }
    
    public boolean hasConnection(Coordinate coordinate) {
        int y = coordinate.getY();
        int x = coordinate.getX();
        if (!ladderHeight.isValidRow(y) || !personCount.isValidLineIndex(x)) {
            return false;
        }
        return rows[y][x] == 1;
    }

    private void validateCoordinateRange(Coordinate coordinate) {
        if (coordinate == null) {
            throw new InvalidCoordinateException(ErrorMessage.NULL_COORDINATE.getMessage());
        }

        int y = coordinate.getY();
        int x = coordinate.getX();

        if (!ladderHeight.isValidRow(y)) {
            throw new InvalidCoordinateException(ErrorMessage.INVALID_COORDINATE_Y.format(y, ladderHeight.getValue()-1));
        }

        if (!personCount.isValidLineIndex(x)) {
            throw new InvalidCoordinateException(ErrorMessage.INVALID_COORDINATE_X.format(x, personCount.getMaxLineIndex()-1));
        }
    }

    private void validateNoDuplicateLine(Coordinate coordinate) {
        if (hasConnection(coordinate)) {
            throw new DuplicateLineException(ErrorMessage.DUPLICATE_LINE.format(coordinate.getY(), coordinate.getX()));
        }
    }
    
    public int getHeight() {
        return ladderHeight.getValue();
    }

    public int getNumberOfPerson() {
        return personCount.getValue();
    }
}