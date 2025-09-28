package ladder.core;

import ladder.unit.LadderPosition;
import ladder.unit.Row;

public class LadderViewer {

    private final Row[] rows;

    private LadderViewer(Row[] rows) {
        this.rows = rows;
    }

    public static LadderViewer from(Row[] rows) {
        return new LadderViewer(rows);
    }

    public void PrintLadder(LadderPosition ladderPosition, String ladderLabel) {
        System.out.println(ladderLabel);
        for (int i = 0; i < rows.length; i++) {
            StringBuilder sb = rows[i].createRowString(ladderPosition, i);
            System.out.println(sb.toString());
        }
    }
}
