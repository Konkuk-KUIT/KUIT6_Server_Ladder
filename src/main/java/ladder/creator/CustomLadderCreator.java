package ladder.creator;

import ladder.exception.ErrorMessage;
import ladder.util.GreaterThanOne;
import ladder.position.Position;
import ladder.core.Row;

public class CustomLadderCreator implements LadderCreatorPort {
    private final Row[] rows;
    private final LadderSize size;

    public CustomLadderCreator(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        this.size = new LadderSize(numberOfRows, numberOfPerson);
        this.rows = new Row[size.rows()];
        for (int r = 0; r < size.rows(); r++) {
            rows[r] = new Row(numberOfPerson);
        }
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public void drawLine(Position row, Position col) {
        validateRowIndexForDraw(row);
        rows[row.getValue()].drawLine(col);
    }

    private void validateRowIndexForDraw(Position row) {
        int r = row.getValue();
        if (r < 0 || r >= rows.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }


    @Override public int getNumberOfPerson()  {
        return size.cols();
    }
}