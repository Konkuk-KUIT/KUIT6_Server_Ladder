public class Ladder {

    private final int[][] rows;

    public int getLadderInfoByPosition(Position position) {
        if (position.getX() >= rows[0].length || position.getY() >= rows.length) {
            throw new IllegalArgumentException("Invalid position");
        }
        return rows[position.getY()][position.getX()];
    }

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawLine(Position pos1, Position pos2) {
        if (pos1.getY() != pos2.getY() || pos1.getX() == pos2.getX()) {
            throw new IllegalArgumentException("Invalid position");
        }
        rows[pos1.getY()][pos1.getX()] = pos2.getX() - pos1.getX();
        rows[pos2.getY()][pos2.getX()] = pos1.getX() - pos2.getX();
    }

    public int run(int startX) {
        if (startX < 0 || startX >= rows[0].length) {
            throw new ArrayIndexOutOfBoundsException("Invalid start position");
        }
        int finalX = startX;
        for (int[] row : rows) {
            finalX += row[finalX];
        }
//        for (int depth = 0; depth < rows.length; depth++) {
//            finalX += rows[depth][finalX];
//        }
        return finalX;
    }
}
