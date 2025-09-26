package creator;

import domain.LadderSize;
import domain.Row;

public class CustomLadderCreator implements LadderCreator {
    private final Row[] rows;

    public CustomLadderCreator(LadderSize size) {
        this.rows = new Row[size.numberOfRow()];
        for (int i = 0; i < size.numberOfRow(); i++) {
            rows[i] = new Row(size.numberOfPerson());
        }
    }

    @Override
    public void drawLine(int row, int person) {
        if (row < 0 || row >= rows.length) {
            throw new IllegalArgumentException("유효하지 않은 행 인덱스입니다: " + row);
        }
        rows[row].drawLine(person);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
