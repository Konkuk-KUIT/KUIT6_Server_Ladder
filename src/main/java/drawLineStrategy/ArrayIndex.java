package drawLineStrategy;

import java.util.Objects;
import java.util.Random;

public class ArrayIndex {
    private int x;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    private int y;

    private ArrayIndex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static ArrayIndex RandomIndex(int row, int col){
        Random random = new Random();
        return new ArrayIndex(random.nextInt(row), random.nextInt(col));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArrayIndex that)) return false;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
