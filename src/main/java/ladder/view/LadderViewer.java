package ladder.view;

import ladder.domain.Direction;
import ladder.domain.PlayerState;
import ladder.domain.Position;
import ladder.domain.Row;

public class LadderViewer {
    private LadderViewer() {}

    public static LadderViewer from() {
        return new LadderViewer();
    }

    public void print(Row[] rows, PlayerState playerState,int turn) {
        System.out.println(turn+".");
        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            Row row = rows[rowIndex];
            Position playerPosition = (rowIndex == playerState.getRowIndex())
                    ? playerState.getPosition()
                    : null;

            System.out.println(renderRow(row, playerPosition));
        }
    }

    private String renderRow(Row row, Position playerPosition) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row.getNodes().length; i++) {
            sb.append("|");

            if (playerPosition != null && i == playerPosition.getValue()) {
                sb.append("*");
            } else {
                sb.append(" ");
            }

            if (row.getNodes()[i].getDirection()== Direction.RIGHT) {
                sb.append("- ");
            } else {
                sb.append("  ");
            }
        }
        return sb.toString();
    }




}
