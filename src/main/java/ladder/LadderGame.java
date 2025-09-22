package ladder;

import ladder.Creator.LadderCreator;

import ladder.Displayer.LadderDisplayer;

public class LadderGame {

    private final LadderCreator ladderCreator;


    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {

        // 1. 사다리의 생성을 요청
        Row[] rows = ladderCreator.getRows();

        // TODO : 사다리를 출력하는 기능 추가
        // LadderDisplayer ladderDisplayer = new LadderDisplayer(rows);
        // ladderDisplayer.displayNodes();
        // 이런식으로 객체를 반복문안에서 생성해도되나??

        // 2. runner 에게 완성된 사다리를 건네준다.
        LadderRunner ladderRunner = new LadderRunner(rows);

        // 3. runner 에게 사다리를 타라고 메세지를 보낸다.
        return ladderRunner.run(position);
    }
}
