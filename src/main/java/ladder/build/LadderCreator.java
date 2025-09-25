package ladder.build;

import ladder.domain.GreaterThanOne;
import ladder.domain.Position;
import ladder.domain.Row;
import ladder.support.ErrorMessage;

public class LadderCreator {

    private final Row[] rows;


    public LadderCreator(GreaterThanOne row, GreaterThanOne numberOfPerson) {
        rows = new Row[row.getNumber()];
        for (int i = 0; i < row.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public Row[] getRows(){
        return rows;
    }

    public void drawLine(Position row, Position col){
        int r = row.getValue();
        if (r < 0 || r >= rows.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
        rows[r].drawLine(col);
    }
}
