package ladder;

import ladder.Creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    /**
     *  사다리 성질에 맞는 LadderCreator 클래스를 받아서, 사다리 진행 총괄을 담당하는 클래스이다.
     *  사다리 운영에 필요한 run() 메서드와 drawLine()메서드를 내부적으로 가지고 있다.
     *  하지만 실질적인 구현은 위 메서드를 담당하는 클래스에서 책임을 지며, 지금 클래스에서는 호출만 진행한다.
     */
    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position){

        // 1. 사다리의 생성을 요청
        Row[] rows = ladderCreator.getRows();
        // 2. runner 에게 완성된 사다리를 건네준다.
        LadderRunner ladderRunner = new LadderRunner(rows);
        // 3. runner 에게 사다리를 타라고 메세지를 보낸다.
        return ladderRunner.run(position);
    }


    public void drawLine(Position row, Position col){
        ladderCreator.drawLine(row, col);
    }
}
