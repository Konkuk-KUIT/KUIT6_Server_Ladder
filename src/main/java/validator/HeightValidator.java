package validator;

import domain.Direction;
import domain.Row;
import exception.IllegalHeightException;

public class HeightValidator {
    public static void validateHeight(int left, int right, Row[] rows, int height) {
        if (height <= 0) throw new IllegalHeightException();
        if (height > rows.length) throw new IllegalHeightException();
        if (rows[height - 1].getNodeValue(left - 1) != Direction.NONE.getValue()
                || rows[height - 1].getNodeValue(right - 1) != Direction.NONE.getValue()) {
            throw new IllegalHeightException();
        }
    }
}
