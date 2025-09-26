package Ladder.Ladder;

import Ladder.Core.Position;
import Ladder.Core.Row;

public class LadderViewer {
    private final Row[] rows;
    private final LadderPosition ladderPosition;

    public LadderViewer(Row[] rows, LadderPosition ladderPosition) {
        this.rows = rows;
        this.ladderPosition = ladderPosition;
    }

    public void printLadder() {
        for (int i = 0; i < rows.length; i++) {
            rows[i].generateRow(Position.from(i), ladderPosition);
            System.out.println();
        }
        System.out.println();
    }
}
