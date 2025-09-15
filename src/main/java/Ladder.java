import java.awt.image.ColorModel;

public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawLine(Position from, Position to) {
        allCheck(from, to);

        int previousX = Math.min(from.getX(), to.getX());

        rows[from.getY()][previousX] = 1;
    }

    private void allCheck(Position from, Position to) {
        //높이가 같지 않은 지점을 서로 이으려고 할 때
        checkSameLevel(from, to);

        //거리가 1이 아닌 경우
        checkLength(from, to);

        //사다리의 경계 또는 경계 밖 이으려고 할 때
        checkBoundary(from, to);

        //중복 검증
        checkDuplicate(from, to);
    }

    private void checkDuplicate(Position from, Position to) {
        if (canMoveLeft(from) || canMoveRight(from)
        || canMoveLeft(to) || canMoveRight(to))
            throw new IllegalStateException("중복해서 사다리를 이을 수 없습니다.");
    }

    public int run(int column) {
        //범위를 넘어서서 시작
        checkStartRange(column);

        int currentX = column;
        int currentY = 0;

        boolean isMoved = false; //옆으로 이동했는지
        while (currentY != rows.length - 1) {
            //왼쪽으로 이동 가능?
            if (!isMoved && canMoveLeft(new Position(currentX, currentY))) {
                currentX--;
                isMoved = true;
                continue;
            }
            //오른쪽으로 이동 가능?
            if (!isMoved && canMoveRight(new Position(currentX, currentY))) {
                currentX++;
                isMoved = true;
                continue;
            }
            isMoved = false;
            currentY++;
        }
        return currentX;
    }

    private boolean canMoveRight(Position cur) {
        return cur.getX() != rows[0].length - 1 && rows[cur.getY()][cur.getX()] == 1;
    }

    private boolean canMoveLeft(Position cur) {
        return cur.getX() != 0 && rows[cur.getY()][cur.getX() - 1] == 1;
    }


    private void checkStartRange(int column) {
        if (column < 0 || column > rows[0].length - 1)
            throw new IllegalStateException("경계를 넘어서서 접근이 불가합니다.");
    }

    private void checkBoundary(Position from, Position to) {
        if (from.getY() == 0 || from.getY() == (rows.length - 1))
            throw new IllegalStateException("사다리의 경계는 이을 수 없습니다.");

        if (from.getX() < 0 || from.getX() > rows[0].length - 1
                || to.getX() < 0 || to.getX() > rows[0].length - 1
                || from.getY() < 0 || from.getY() > rows.length - 1
                || to.getY() < 0 || to.getY() > rows.length - 1)
            throw new IllegalStateException("경계 밖은 이을 수 없습니다.");
    }

    private static void checkLength(Position from, Position to) {
        if (Math.abs(from.getX() - to.getX()) != 1)
            throw new IllegalStateException("사다리는 1개씩 그릴 수 있으며 동일한 지점을 이을 수 없습니다.");
    }

    private static void checkSameLevel(Position from, Position to) {
        if (from.getY() != to.getY())
            throw new IllegalStateException("높이가 다른 지점은 이을 수 없습니다.");
    }
}
