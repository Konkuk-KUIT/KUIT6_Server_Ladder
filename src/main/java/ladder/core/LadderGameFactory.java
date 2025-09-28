package ladder.core;

import ladder.Creator.CustomLadderCreator;
import ladder.Creator.RandomLadderCreator;
import ladder.unit.LadderSize;

public class LadderGameFactory {
    public static LadderGame randomLadderGame(LadderSize ladderSize) {
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderSize);
        return new LadderGame(randomLadderCreator);
    }
    public static LadderGame customLadderGame(LadderSize ladderSize) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        return new LadderGame(customLadderCreator);
    }
}
