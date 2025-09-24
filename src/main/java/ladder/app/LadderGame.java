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
        // 1. 사다리 생성을 요청
        Row[] rows = ladderCreator.getRows();
        LadderViewer ladderViewer = LadderViewer.from();

        // 2. Runner에게 완성된 사다리를 전달
        LadderRunner ladderRunner = new LadderRunner(rows);

        // 3. Runner에게 사다리를 타라고 메세지 전달
        return ladderRunner.run(position, ladderViewer);
    }
}
