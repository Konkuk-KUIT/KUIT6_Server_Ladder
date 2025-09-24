public class Validation {

    public static String validate(Row[] rows, int leftColumn, int rightColumn, Height height) {
        if (isOutOfHeight(height, rows)) {
            return ErrorMessage.OUT_OF_HEIGHT.getMessage();
        }
        if (isSameColumn(leftColumn, rightColumn)) {
            return ErrorMessage.SAME_COLUMN.getMessage();
        }
        if (isAlreadyOccupied(rows, height, leftColumn, rightColumn)) {
            return ErrorMessage.SAME_COLUMN.getMessage();
        }
        if (isOverlap(rows, height, leftColumn, rightColumn)) {
            return ErrorMessage.SAME_COLUMN.getMessage();
        }

        return null;
    }

    private static boolean isOutOfHeight(Height height, Row[] rows) {
        return height.current() >= rows.length;
    }

    private static boolean isSameColumn(int leftColumn, int rightColumn) {
        return leftColumn == rightColumn;
    }

    private static boolean isAlreadyOccupied(Row[] rows, Height height, int leftColumn, int rightColumn) {
        int min = Math.min(leftColumn, rightColumn) - 1;
        int max = Math.max(leftColumn, rightColumn) - 1;
        return rows[height.current()].line()[min] != 0 || rows[height.current()].line()[max] != 0;
    }

    private static boolean isOverlap(Row[] rows, Height height, int leftColumn, int rightColumn) {
        int min = Math.min(leftColumn, rightColumn) - 1;
        int max = Math.max(leftColumn, rightColumn) - 1;

        // 왼쪽 겹침 검사
        if (min - 1 >= 0 && rows[height.current()].line()[min - 1] == Direction.RIGHT.getValue()) {
            return true;
        }

        // 오른쪽 겹침 검사
        if (max + 1 < rows[0].length() && rows[height.current()].line()[max + 1] == Direction.LEFT.getValue()) {
            return true;
        }

        return false;
    }
}