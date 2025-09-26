package ladder.game;

import ladder.creator.CustomLadderCreator;
import ladder.creator.RandomLadderCreator;
import ladder.domain.LadderSize;

public class LadderGameFactory {

    public static LadderGame customLadderGame(LadderSize ladderSize) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        return new LadderGame(customLadderCreator);
    }
    public static LadderGame randomLadderGame(LadderSize ladderSize) {
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(customLadderCreator);
        return new LadderGame(randomLadderCreator);
    }

}
