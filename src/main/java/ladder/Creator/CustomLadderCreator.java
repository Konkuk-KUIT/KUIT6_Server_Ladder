package ladder.Creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

public class CustomLadderCreator implements LadderCreator {
    private final Row[] rows;

    public CustomLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public Row[] getRows() {
        return rows;
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }
}
