package ladder.engine;

import ladder.domain.PlayerState;
import ladder.domain.Position;
import ladder.domain.Row;
import ladder.view.LadderViewer;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position startPosition, LadderViewer viewer) {

        Position pos = startPosition;
        int rowIndex = 0;
        int turn = 0;

        // 초기 상태
        print(viewer, rowIndex, pos, turn++);

        for (int i = 0; i < rows.length; i++) {
            // 가로 이동 결과
            pos = rows[i].moveNextPosition(pos);
            print(viewer, rowIndex, pos, turn++);

            // 다음 행으로 '내려온' 상태(위치 변화 없음)
            rowIndex++;
            print(viewer, rowIndex, pos, turn++);
        }
        return pos;
    }

    private void print(LadderViewer viewer, int rowIndex, Position pos, int turn) {
        viewer.print(rows, PlayerState.from(rowIndex, pos), turn);
    }
}
