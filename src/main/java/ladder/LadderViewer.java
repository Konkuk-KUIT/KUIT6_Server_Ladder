package ladder;

import ladder.position.LadderPosition;
import ladder.position.Position;

public class LadderViewer {

    private final Row[] rows;

    public LadderViewer(Row[] rows) {
        this.rows = rows;
    }

    public void printLadderStatus(LadderPosition ladderPosition, LadderLabel ladderLabel){
        String generate = generate(ladderPosition, ladderLabel);
        System.out.println(generate);
    }

    private String generate(LadderPosition ladderPosition, LadderLabel ladderLabel) {
        StringBuilder sb = new StringBuilder();
        appendLabel(sb, ladderLabel);
        for (int i = 0; i < rows.length; i++) {
            rows[i].generateRow(sb, Position.from(i), ladderPosition);
        }
        return sb.toString();
    }

    private void appendLabel(StringBuilder sb, LadderLabel ladderLabel) {
        sb.append(ladderLabel.getValue());
    }
}
