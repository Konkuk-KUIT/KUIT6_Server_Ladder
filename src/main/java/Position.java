public class Position {

    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public boolean equals (Object o) {
        Position p = (Position) o;
        return p.getX() == x && p.getY() == y;
    }
}
