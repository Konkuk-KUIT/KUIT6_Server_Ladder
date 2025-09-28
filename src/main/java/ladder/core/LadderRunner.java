package ladder.core;

import ladder.unit.LadderPosition;
import ladder.unit.Position;
import ladder.unit.Row;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position){
        LadderViewer ladderViewer = LadderViewer.from(rows);
        for(int i = 0; i < rows.length; i++){
            ladderViewer.PrintLadder(LadderPosition.of(i, position), "Before");
            rows[i].nextPosition(position);
            ladderViewer.PrintLadder(LadderPosition.of(i, position), "After");
        }
        return position.getValue();
    }
}
