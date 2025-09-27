package ladder.Creator;

import ladder.Domain.GreaterThanOne;
import ladder.Domain.Position;
import ladder.Domain.Row;

public class ManualLadderCreator implements LadderCreator {

    private final Row[] rows;

    public ManualLadderCreator(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRows.getNumber()];
        for (int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }
}