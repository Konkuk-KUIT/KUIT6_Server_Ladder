package ladder.Creator;

import ladder.unit.LadderPosition;
import ladder.unit.LadderSize;
import ladder.unit.Position;
import ladder.unit.Row;

public class CustomLadderCreator implements LadderCreator {

    private final Row[] rows;

    public CustomLadderCreator(LadderSize ladderSize) {
        rows = createLadder(ladderSize);
    }

    public static Row[] createLadder(LadderSize ladderSize) {
        final Row[] rows;
        rows = new Row[ladderSize.getNumberOfRow().getNumber()];
        for (int i = 0; i < ladderSize.getNumberOfRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
        return rows;
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getRow()].drawLine(Position.from(ladderPosition.getPosition()));
    }
}
