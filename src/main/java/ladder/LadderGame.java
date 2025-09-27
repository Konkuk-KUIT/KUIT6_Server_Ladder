package ladder;

import ladder.Creator.LadderCreator;
import ladder.Creator.LadderCreatorFactory;
import ladder.Domain.GreaterThanOne;
import ladder.Domain.Position;
import ladder.Domain.Row;
import ladder.Runner.LadderRunner;

public class LadderGame {

    private final LadderCreator ladderCreator;

    private LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }
    public static LadderGame createLadderGame(LadderCreator ladderCreator) {
    return new LadderGame(ladderCreator);
    }


    public int run(Position position){

        // 1. 사다리의 생성을 요청
        Row[] rows = ladderCreator.getRows();

        // 2. runner 에게 완성된 사다리를 건네준다.
        LadderRunner ladderRunner = new LadderRunner(rows);

        // 3. runner 에게 사다리를 타라고 메세지를 보낸다.
        return ladderRunner.run(position);
    }
}
