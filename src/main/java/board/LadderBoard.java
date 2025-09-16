package board;

import exceptions.DuplicateLineException;
import exceptions.InvalidCoordinateException;
import position.Coordinate;

public class LadderBoard implements Board {
    
    private final int[][] rows;
    private final int numberOfPerson;
    private final int height;
    
    public LadderBoard(int numberOfPerson, int height) {
        this.numberOfPerson = numberOfPerson;
        this.height = height;
        this.rows = new int[height][numberOfPerson - 1];
    }
    
    public void drawLine(Coordinate coordinate) {
        validateCoordinateRange(coordinate);
        validateNoDuplicateLine(coordinate);
        rows[coordinate.getY()][coordinate.getX()] = 1;
    }
    
    public boolean hasConnection(Coordinate coordinate) {
        int y = coordinate.getY();
        int x = coordinate.getX();
        if (y < 0 || y >= height || x < 0 || x >= numberOfPerson - 1) {
            return false;
        }
        return rows[y][x] == 1;
    }

    private void validateCoordinateRange(Coordinate coordinate) {
        if (coordinate == null) {
            throw new IllegalArgumentException("좌표는 null일 수 없습니다");
        }

        int y = coordinate.getY();
        int x = coordinate.getX();

        if (y < 0 || y >= height) {
            throw new InvalidCoordinateException("Y 좌표가 범위를 벗어났습니다: " + y + " (0-" + (height-1) + ")");
        }

        if (x < 0 || x >= numberOfPerson - 1) {
            throw new InvalidCoordinateException("X 좌표가 범위를 벗어났습니다: " + x + " (0-" + (numberOfPerson-2) + ")");
        }
    }

    private void validateNoDuplicateLine(Coordinate coordinate) {
        if (hasConnection(coordinate)) {
            throw new DuplicateLineException("이미 선이 존재합니다: (" + coordinate.getY() + ", " + coordinate.getX() + ")");
        }
    }
    
    public int getHeight() {
        return height;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }
}