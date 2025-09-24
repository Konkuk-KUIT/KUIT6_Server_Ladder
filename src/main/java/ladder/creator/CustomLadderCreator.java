package ladder.creator;

import ladder.GreaterThanOne;
import ladder.position.LadderPosition;
import ladder.position.Position;
import ladder.Row;

public class CustomLadderCreator implements LadderCreator{

    private final Row[] rows;

    public CustomLadderCreator(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRows.getNumber()];
        for (int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {

    }

    public Row[] getRows() {
        return rows;
    }

    public void drawLine(Position row, Position col){
        rows[row.getValue()].drawLine(col);
    }
}
