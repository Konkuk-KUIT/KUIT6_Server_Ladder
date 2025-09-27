package ladder.Viewer;

import ladder.Constant.LadderState;
import ladder.Domain.Position;
import ladder.Domain.Row;

public class LadderViewers {
    private final Row[] rows;

    private LadderViewers(Row[] rows) {
        this.rows = rows;
    }

    public static LadderViewers create(Row[] rows) {
        return new LadderViewers(rows);
    }

    public void ladder_Print(Position position, int highlightRow, String state) {
        System.out.println(state);
        for (int i = 0; i < rows.length; i++) {
            if (i == highlightRow) {
                rows[i].currentPrint(position); // ★ 현재 줄만 별표
            } else {
                rows[i].print();                // 나머지는 평소 출력
            }
        }
        System.out.println();
    }

}
