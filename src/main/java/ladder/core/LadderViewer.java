package ladder.core;

import ladder.position.LadderPosition;

public class LadderViewer {
    private final StringBuilder out = new StringBuilder();

    public void label(String text) { out.append(text).append('\n'); }
    public void appendLine(String line) { out.append(line).append('\n'); }
    public void blank() { out.append('\n'); }
    public String render() { return out.toString(); }

    public void snapshotAllRows(Row[] rows, LadderPosition star) {
        for (int r = 0; r < rows.length; r++) {
            LadderPosition pass = (star != null && star.row() == r) ? star : null;
            appendLine(rows[r].renderLine(pass));
        }
        blank();
    }
}