package board;

import exceptions.DuplicateLineException;
import exceptions.InvalidCoordinateException;
import position.Coordinate;
import wrap.PersonCount;
import wrap.LadderHeight;

public class LadderBoard implements Board {
    
    private final int[][] rows;
    private final PersonCount personCount;
    private final LadderHeight ladderHeight;
    
    public LadderBoard(PersonCount personCount, LadderHeight ladderHeight) {
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
            throw new InvalidCoordinateException("좌표는 null일 수 없습니다");
        }

        int y = coordinate.getY();
        int x = coordinate.getX();

        if (!ladderHeight.isValidRow(y)) {
            throw new InvalidCoordinateException("Y 좌표가 범위를 벗어났습니다: " + y + " (0-" + (ladderHeight.getValue()-1) + ")");
        }

        if (!personCount.isValidLineIndex(x)) {
            throw new InvalidCoordinateException("X 좌표가 범위를 벗어났습니다: " + x + " (0-" + (personCount.getMaxLineIndex()-1) + ")");
        }
    }

    private void validateNoDuplicateLine(Coordinate coordinate) {
        if (hasConnection(coordinate)) {
            throw new DuplicateLineException("이미 선이 존재합니다: (" + coordinate.getY() + ", " + coordinate.getX() + ")");
        }
    }
    
    public int getHeight() {
        return ladderHeight.getValue();
    }

    public int getNumberOfPerson() {
        return personCount.getValue();
    }
}