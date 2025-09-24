package position;

public class Position implements Coordinate, Movable {
    
    private final int y;
    private final int x;
    
    private Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    public static Position at(int y, int x) {
        return new Position(y, x);
    }
    
    @Override
    public int getY() {
        return y;
    }
    
    @Override
    public int getX() {
        return x;
    }
    
    @Override
    public Coordinate moveLeft() {
        return Position.at(y, x - 1);
    }
    
    @Override
    public Coordinate moveRight() {
        return Position.at(y, x + 1);
    }
    
    @Override
    public Coordinate moveUp() {
        return Position.at(y - 1, x);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return y == position.y && x == position.x;
    }

    @Override
    public int hashCode() {
        return 31 * y + x;
    }

    @Override
    public String toString() {
        return "Position{" + "y=" + y + ", x=" + x + '}';
    }
}