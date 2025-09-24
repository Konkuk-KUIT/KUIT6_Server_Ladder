package ladder;

import ladder.position.Position;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position){
        LadderViewer ladderViewer = new LadderViewer(rows);
        for (Row row : rows) {
            row.nextPosition(position);
        }
        return position.getValue();
    }
}
