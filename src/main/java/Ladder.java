public class Ladder {
    private final int height, lines;
    private final boolean[][] rail; // [height][lines-1], rail[r][p] == true -> (p)-(p+1) 연결

    public Ladder(int height, int lines) {
        if (lines < 2 || height < 1) throw new IllegalArgumentException();
        this.height = height; this.lines = lines;
        this.rail = new boolean[height][lines - 1];
    }

    public void drawLine(int row, int position) {
        int r = toZero(row, height, "row");
        int p = toZero(position,  lines - 1, "position");
        ensureNoAdjacent(r, p);
        rail[r][p] = true;
    }

    public int run(int start1) {
        int c = toZero(start1, lines, "start");
        for (int r = 0; r < height; r++) {
            if (c < lines - 1 && rail[r][c]) c++;         // 오른쪽
            else if (c > 0 && rail[r][c - 1]) c--;        // 왼쪽
        }
        return c + 1;
    }

    private void ensureNoAdjacent(int r, int p) {
        if (rail[r][p]) throw new IllegalArgumentException("중복 금지");
        if (p > 0 && rail[r][p - 1]) throw new IllegalArgumentException("왼쪽 인접 금지");
        if (p + 1 < lines - 1 && rail[r][p + 1]) throw new IllegalArgumentException("오른쪽 인접 금지");
    }

    private int toZero(int one, int max, String name) {
        if (one < 1 || one > max) throw new IllegalArgumentException(name+" in 1.."+max);
        return one - 1;
    }
}
