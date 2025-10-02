import java.io.PrintStream;

public class LadderConsolePrinter implements LadderTraversalObserver {
    private final PrintStream out;

    public LadderConsolePrinter() {
        this(System.out);
    }

    public LadderConsolePrinter(PrintStream out) {
        // this.out = out;
        this.out = java.util.Objects.requireNonNull(out, "out");
    }

    @Override
    public void beforeStep(int rowIndex, int currentPosition, Ladder ladder) {
        out.println("Before");
        printLadder(rowIndex, currentPosition, ladder);
        out.println();
    }

    @Override
    public void afterStep(int rowIndex, int currentPosition, Ladder ladder) {
        out.println("After");
        printLadder(rowIndex, currentPosition, ladder);
        out.println();
    }

    private void printLadder(int focusedRow, int highlightedPosition, Ladder ladder) {
        Row[] rows = ladder.getRows();
        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            Row row = rows[rowIndex];
            out.println(renderRow(row, rowIndex == focusedRow ? highlightedPosition : -1));
        }
    }

    private String renderRow(Row row, int highlightedPosition) {
        StringBuilder builder = new StringBuilder();
        int width = row.width();
        for (int column = 0; column < width; column++) {
            builder.append(column);
            if (column == highlightedPosition) {
                builder.append('*');
            }
            if (column < width - 1) {
                builder.append(row.connectsToRightFrom(column) ? " - " : "   ");
            }
        }
        return builder.toString();
    }
}