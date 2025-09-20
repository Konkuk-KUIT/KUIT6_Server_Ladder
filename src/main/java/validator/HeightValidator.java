package validator;

import direction.Direction;
import exception.IllegalHeightException;

public class HeightValidator {
    public static void validateHeight(int left, int right, int[][] rows, int height) {
        if (height <= 0) throw new IllegalHeightException();
        if (height > rows.length) throw new IllegalHeightException();
        if (rows[height - 1][left - 1] != Direction.NONE.getValue()
                || rows[height - 1][right - 1] != Direction.NONE.getValue()) {
            throw new IllegalHeightException();
        }
    }
}
