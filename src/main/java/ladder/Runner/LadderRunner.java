package ladder.Runner;

import ladder.Constant.LadderState;
import ladder.Domain.Position;
import ladder.Domain.Row;
import ladder.Viewer.LadderViewers;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position){
        LadderViewers ladderViewers = LadderViewers.create(rows);
        int currentRow = 0;
        for (Row row : rows) {
//            row.currentPrint(position);
            ladderViewers.ladder_Print(position,currentRow, LadderState.LADDER_STATE_BEFORE.getMessage());
            row.nextPosition(position);
            ladderViewers.ladder_Print(position,currentRow, LadderState.LADDER_STATE_AFTER.getMessage());
            currentRow++; // ← 직접 증가
//            row.currentPrint(position);
        }
        return position.getValue();
    }
}
