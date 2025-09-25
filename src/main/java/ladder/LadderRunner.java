package ladder;

import ladder.model.Position;
import ladder.model.Row;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position){
        for (int i = 0; i < rows.length; i++) {
            rows[i].nextPosition(position);
        }

        return position.getValue();
    }

    public void runWithPrint(Position position){

        LadderPrinter ladderPrinter = new LadderPrinter(rows);

        for (int i = 0; i < rows.length; i++) {
            System.out.println("Before");
            ladderPrinter.renderLadderWithPosition(position,i);

            rows[i].nextPosition(position);

            System.out.println("After");
            ladderPrinter.renderLadderWithPosition(position,i);
        }
    }

}
