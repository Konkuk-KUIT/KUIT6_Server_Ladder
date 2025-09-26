public class LadderViewer {

    private final LadderLine[] rows;

    public LadderViewer(LadderLine[] rows) {
        this.rows = rows;
    }

    public void print(LadderPosition current, String label) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(label).append("]").append("\n");

        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            sb.append(renderRow(rowIndex, current)).append("\n");
        }

        sb.append("\n");
        System.out.print(sb);
    }

    private String renderRow(int rowIndex, LadderPosition current) {
        StringBuilder line = new StringBuilder();
        Node[] nodes = rows[rowIndex].getNodes();

        for (int colIndex = 0; colIndex < nodes.length; colIndex++) {
            line.append(renderCell(rowIndex, colIndex, current, nodes));
        }

        return line.toString();
    }

    private String renderCell(int rowIndex, int colIndex, LadderPosition current, Node[] nodes) {
        StringBuilder cell = new StringBuilder();

        if (current.getRowPosition() == rowIndex && current.getColPosition() == colIndex) {
            cell.append("*");
        } else {
            cell.append("|");
        }

        if (colIndex < nodes.length - 1) {
            if (nodes[colIndex].isRight()) {
                cell.append("---");
            } else {
                cell.append("   ");
            }
        }

        return cell.toString();
    }
}