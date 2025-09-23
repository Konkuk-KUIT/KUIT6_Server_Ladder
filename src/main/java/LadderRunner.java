
public class LadderRunner {

    private final int[][] rows;

    public LadderRunner(int[][] rows) {
        this.rows = rows;
    }

    public int run(int column) {

        //범위를 넘어서서 시작
        checkStartRange(column);

        Position pos = Position.from(column, 0);

        System.out.println("[BEFORE]");
        draw(pos, rows);

        boolean isMoved = false; //옆으로 이동했는지
        while (pos.getY() != rows.length - 1) {
            //왼쪽으로 이동 가능?
            if (!isMoved && pos.canMoveLeft(rows)) {
                pos.moveLeft();
                System.out.println("[AFTER]");
                draw(pos, rows);
                isMoved = true;
                continue;
            }
            //오른쪽으로 이동 가능?
            if (!isMoved && pos.canMoveRight(rows)) {
                pos.moveRight();
                System.out.println("[AFTER]");
                draw(pos, rows);
                isMoved = true;
                continue;
            }
            isMoved = false;
            pos.moveDown();
            System.out.println("[BEFORE]");
            draw(pos, rows);
        }

        return pos.getX();
    }

    private void draw(Position pos, int[][] rows) {
        for (int y=0; y< rows.length; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x=0; x< rows[0].length; x++) {
                if (pos.x == x && pos.y == y)
                    sb.append("*");
                else
                    sb.append("ㅣ");

                if (Position.from(x, y).canMoveRight(rows)) {
                    sb.append("-");
                } else {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public void checkStartRange(int column) {
        if (column < 0 || column > rows[0].length - 1)
            throw new IllegalStateException(ErrorMessage.INVALID_START_RANGE.getMsg());
    }
}
