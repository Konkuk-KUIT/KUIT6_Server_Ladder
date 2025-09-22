package ladder;

import ladder.View.LadderView;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position){
        for (int i = 0; i < rows.length; i++) {
            LadderView.printASCII(rows,i, position.getValue());
            if(rows[i].nextPosition(position)) {
                LadderView.printASCII(rows, i, position.getValue());
            }
        }
        return position.getValue();
    }
}
