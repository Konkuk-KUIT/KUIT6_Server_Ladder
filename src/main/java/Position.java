import java.util.Objects;

public class Position {

    int x;
    int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position from(int x, int y) {
        return new Position(x, y);
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void moveDown() {
        y++;
    }

    public boolean canMoveLeft(int[][] rows) {
        return x > 0 && rows[y][x - 1] == ExistFlag.EXIST.getValue();
    }

    public boolean canMoveRight(int[][] rows) {
        return x < rows[0].length-1 && rows[y][x] == ExistFlag.EXIST.getValue();
    }

    @Override
    public boolean equals(Object o) {
        Position p = (Position)o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
