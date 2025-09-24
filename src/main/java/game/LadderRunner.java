package game;

import domain.Ladder;
import domain.LadderNumber;
import domain.Row;
import view.GameViewRenderer;

public class LadderRunner {
    private final Row[] rows;

    private LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public static LadderRunner from(Ladder ladder){
        return new LadderRunner(ladder.getRows());
    }

    public int run(LadderNumber ladderNum) {
        int col = ladderNum.getNumber() - 1;
        GameViewRenderer.ladderRender(rows);
        for (int height = 0; height < rows.length; height++) {
            GameViewRenderer.gameRender(GameState.BEFORE.getState(), rows, col, height);
            col += rows[height].getNodeValue(col);
            GameViewRenderer.gameRender(GameState.AFTER.getState(), rows, col, height);
        }
        return col + 1;
    }
}
