public class LadderCreator {

    private final int[][] rows;

    private final int LEFT_BOUNDARY = 0;
    private final int RIGHT_BOUNDARY;
    private final int UP_BOUNDARY = 0;
    private final int DOWN_BOUNDARY;

    public LadderCreator(GreaterThanOne row, GreaterThanOne numberOfPerson) {
        rows = new int[row.getNum()][numberOfPerson.getNum()];
        RIGHT_BOUNDARY = rows[0].length - 1;
        DOWN_BOUNDARY = rows.length - 1;
    }

    public int[][] getRows() {
        return rows;
    }

    public void drawLine(Position from) {
        //사다리의 경계 또는 경계 밖 이으려고 할 때
        checkBoundary(from);

        //중복 검증
        checkDuplicate(from);

        rows[from.getY()][from.getX()] = ExistFlag.EXIST.getValue();
    }

    public void checkBoundary(Position from) {
        if (from.getY() == 0 || from.getY() == (DOWN_BOUNDARY))
            throw new IllegalStateException(ErrorMessage.INVALID_BOUNDARY.getMsg());

        if (from.getX() < LEFT_BOUNDARY || from.getX() > RIGHT_BOUNDARY
                || from.getY() < UP_BOUNDARY || from.getY() > DOWN_BOUNDARY)
            throw new IllegalStateException(ErrorMessage.INVALID_BOUNDARY.getMsg());
    }

    public void checkDuplicate(Position from) {
        if (from.canMoveLeft(rows) || from.canMoveRight(rows) || Position.from(from.getX()+1, from.getY()).canMoveLeft(rows))
            throw new IllegalStateException(ErrorMessage.INVALID_DUPLICATE.getMsg());
    }
}
