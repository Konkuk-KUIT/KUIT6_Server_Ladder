package Ladder.Ladder;

import Ladder.Core.Position;
import Ladder.Core.Row;

public class LadderRunner {
    private final Row[] rows;
    private LadderPosition ladderPosition;
    private LadderViewer ladderViewer;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position){
        for(int i=0; i<rows.length; i++){

            print(i, position);

            rows[i].nextPosition(position);

            print(i, position);
        }
        return position.getValue();
    }

    // todo 이걸 LadderViewer로 옮기는게 낫나
    private void print(int printRow, Position printCol) {
        ladderPosition = LadderPosition.currentPosition(Position.from(printRow), printCol);
        ladderViewer = new LadderViewer(rows, ladderPosition);
        ladderViewer.printLadder();
    }
}
