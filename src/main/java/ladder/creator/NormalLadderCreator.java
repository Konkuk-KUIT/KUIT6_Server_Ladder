package ladder.creator;

import ladder.model.GreaterThanOne;
import ladder.model.Position;
import ladder.model.Row;

public class NormalLadderCreator implements LadderCreator {

    private final Row[] rows;

    public NormalLadderCreator(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRows.getNumber()];
        for (int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public Row[] getRows() {
        return rows.clone();
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

}
