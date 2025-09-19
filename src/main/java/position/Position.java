package position;

public record Position(int y, int x) implements Coordinate, Movable {
    
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
        return new Position(y, x - 1);
    }
    
    @Override
    public Coordinate moveRight() {
        return new Position(y, x + 1);
    }
    
    @Override
    public Coordinate moveUp() {
        return new Position(y - 1, x);
    }
}