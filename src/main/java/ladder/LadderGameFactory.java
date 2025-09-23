package ladder;

import ladder.Creator.RandomLadderCreator;

public class LadderGameFactory {

    public static RandomLadderCreator createLadderGame(LadderSize ladderSize) {
        return new RandomLadderCreator(ladderSize);
    }
}
