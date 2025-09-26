package ladder.printer;

import ladder.domain.Node;
import ladder.domain.Position;
import ladder.domain.Row;

public class LadderPrinter {

    private final Row[] rows;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public void printLadder(int playerRow, Position playerPosition) {
        String ladderString = buildLadderString(playerRow, playerPosition);
        System.out.println(ladderString);
    }

    private String buildLadderString(int playerRow, Position playerPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            String rowString = rows[i].buildRowString(i, playerRow, playerPosition);
            stringBuilder.append(rowString).append("\n");
        }
        return stringBuilder.toString();
    }

}
