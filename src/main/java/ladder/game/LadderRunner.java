package ladder.game;

import ladder.printer.LadderPrinter;
import ladder.domain.Position;
import ladder.domain.Row;

public class LadderRunner {

    private final Row[] rows;
    private final LadderPrinter printer;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
        this.printer = new LadderPrinter(rows);
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println("Before");
            printer.printLadder(i, position);

            rows[i].nextPosition(position);

            System.out.println("After");
            printer.printLadder(i, position);
        }
        return position.getValue();
    }
}
