package ladder;

import ladder.model.Node;
import ladder.model.Position;
import ladder.model.Row;

public class LadderPrinter {

    Row[] rows;

    LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public void renderLadderWithPosition(Position currentColumnPosition, int currentRowPosition) {

        StringBuilder sb = new StringBuilder();

        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            Node[] row = rows[rowIndex].getNodes();
            sb.append(
                    currentRowPosition == rowIndex
                            ? renderRowWithCheck(row, currentColumnPosition)
                            : renderRow(row)
            );
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private String renderRow(Node[] row) {
        StringBuilder sb = new StringBuilder();

        for (Node node : row) {
            sb.append(node.toString()).append("\t");
        }

        return sb.toString();
    }

    private String renderRowWithCheck(Node[] row, Position currentColumnPosition) {
        StringBuilder sb = new StringBuilder();

        for (int column = 0; column < row.length; column++) {
            sb.append(
                    currentColumnPosition.getValue() == column
                            ? row[column].toString() + "*\t"
                            : row[column].toString() + "\t"
            );
        }

        return sb.toString();
    }


}
