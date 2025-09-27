public class LadderRunner {
    private final LadderLine[] rows;
    private final LadderViewer viewer;

    public LadderRunner(LadderLine[] rows) {
        this.rows = rows;
        this.viewer = new LadderViewer(rows);
    }

    public int run(PlayerPosition startCol) {
        PlayerPosition col = startCol;

        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            LadderPosition before = LadderPosition.of(PlayerPosition.from(rowIndex), col);
            viewer.print(before, "Before");

            rows[rowIndex].move(col);

            LadderPosition after = LadderPosition.of(PlayerPosition.from(rowIndex), col);
            viewer.print(after, "After");

        }

        return col.getValue();
    }
}