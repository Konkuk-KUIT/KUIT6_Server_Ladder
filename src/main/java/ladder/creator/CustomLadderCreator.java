package ladder.creator;

import ladder.domain.LadderPosition;
import ladder.domain.LadderSize;
import ladder.domain.Position;
import ladder.domain.Row;
import ladder.validator.GreaterThanOne;

public class CustomLadderCreator implements LadderCreator {
    private final Row[] rows;
    private final LadderSize ladderSize;

    public CustomLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        rows = new Row[ladderSize.getNumberOfRowsValue()];
        for (int i = 0; i < ladderSize.getNumberOfRowsValue(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    public void drawLine(Position row, Position col){
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public void drawLine(LadderPosition position) {
        rows[position.getRow().getValue()].drawLine(position.getCol());
    }

    public LadderSize getLadderSize() {
        return ladderSize;
    }
}
