package ladder.app;

import ladder.build.CustomLadderCreator;
import ladder.build.LadderCreator;
import ladder.build.RandomLadderCreator;
import ladder.domain.GreaterThanOne;
import ladder.domain.LadderSize;

import java.util.Random;

public final class LadderGameFactory {
    private LadderGameFactory() {}

    /** 매번 다른 난수로 자동(랜덤) 보드 생성 */
    public static LadderGame randomLadderGame(LadderSize size) {
        LadderCreator creator = new RandomLadderCreator(size, new Random());
        return new LadderGame(creator);
    }

    /** 시드 고정(재현 가능한) 자동(랜덤) 보드 생성 */
    public static LadderGame randomLadderGame(LadderSize size, long seed) {
        LadderCreator creator = new RandomLadderCreator(size, new Random(seed));
        return new LadderGame(creator);
    }

    /** 수동(커스텀) 보드 생성 */
    public static LadderGame customLadderGame(LadderSize size) {
        LadderCreator creator = new CustomLadderCreator(
                GreaterThanOne.from(size.rows()),
                GreaterThanOne.from(size.persons())
        );
        return new LadderGame(creator);
    }
}
