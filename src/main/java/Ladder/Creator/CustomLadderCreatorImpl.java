package Ladder.Creator;

import Ladder.Core.GreaterThanOne;
import Ladder.Core.Position;
import Ladder.Core.Row;
import Ladder.Ladder.LadderSize;

public class CustomLadderCreatorImpl implements LadderCreator {

    private final Row[] rows;

    private CustomLadderCreatorImpl(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public static CustomLadderCreatorImpl createEmptyLadder(LadderSize ladderSize) {
        return new CustomLadderCreatorImpl(ladderSize.getNumberOfRow(), ladderSize.getNumberOfPerson());
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
