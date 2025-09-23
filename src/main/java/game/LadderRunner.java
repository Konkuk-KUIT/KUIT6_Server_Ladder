package game;

import domain.Row;
import view.GameViewRenderer;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(int ladderNum) {
        int col = ladderNum - 1;
        GameViewRenderer.ladderRender(rows);
        for (int height = 0; height < rows.length; height++) {
            GameViewRenderer.gameRender(GameState.BEFORE.getState(), rows, col, height);
            col += rows[height].getNodeValue(col);
            GameViewRenderer.gameRender(GameState.AFTER.getState(), rows, col, height);
        }
        return col + 1;
    }
}
