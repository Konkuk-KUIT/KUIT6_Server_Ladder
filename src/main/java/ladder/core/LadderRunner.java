package ladder.core;

import ladder.position.LadderPosition;
import ladder.position.Position;

public class LadderRunner {

    private final Row[] rows;
    private final LadderViewer viewer;

    public LadderRunner(Row[] rows) { this(rows, null); }

    public LadderRunner(Row[] rows, LadderViewer viewer) {
        this.rows = rows;
        this.viewer = viewer;
    }
    public int run(LadderPosition start){
        Position col = Position.from(start.col());
        for (int r = 0; r < rows.length; r++) {
            if (viewer != null) {
                viewer.label("Before");
                viewer.snapshotAllRows(rows, LadderPosition.of(r, col.getValue()));
            }

            rows[r].nextPosition(col); // 수평 이동 결정

            if (viewer != null) {
                viewer.label("After");
                viewer.snapshotAllRows(rows, LadderPosition.of(r, col.getValue())); // 전체 보드
                viewer.blank();
            }
        }
        return col.getValue();
    }

}
