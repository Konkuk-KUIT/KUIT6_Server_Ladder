package ladder.app;

import ladder.engine.LadderRunner;
import ladder.build.LadderCreator;
import ladder.domain.Position;
import ladder.domain.Row;
import ladder.view.LadderViewer;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public Position run(Position position){
        Row[] rows = ladderCreator.getRows();
        LadderViewer ladderViewer = LadderViewer.from();
        LadderRunner ladderRunner = new LadderRunner(rows);
        return ladderRunner.run(position, ladderViewer);
    }
}
