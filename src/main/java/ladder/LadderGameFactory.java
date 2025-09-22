package ladder;

import ladder.Creator.AutoFixedLadderCreator;
import ladder.Creator.AutoLadderCreator;
import ladder.Creator.LadderCreator;
import ladder.Creator.NormalLadderCreator;

public final class LadderGameFactory {
    private LadderGameFactory() {}

    // 1) 자동 생성(가로줄 고정)
    public static LadderGame auto(GreaterThanOne nRows,
                                  GreaterThanOne nPersons) {
        LadderCreator creator = new AutoLadderCreator(nRows, nPersons);
        return new LadderGame(creator);
    }

    // 2) 자동 생성(생성 확률 고정)
    public static LadderGame autoFixed(GreaterThanOne nRows,
                                       GreaterThanOne nPersons) {
        LadderCreator creator = new AutoFixedLadderCreator(nRows, nPersons);
        return new LadderGame(creator);
    }

    // 3) 기본 생성
    //todo 직접 생성은 사용자가 생성 라인을 그려줘야 하는데, 이런 로직이면 어떻게 사용자가 가로줄을 넣을 수 있을까?
    public static LadderGame normal(GreaterThanOne nRows,
                                       GreaterThanOne nPersons) {
        LadderCreator creator = new NormalLadderCreator(nRows, nPersons);
        return new LadderGame(creator);
    }

}
