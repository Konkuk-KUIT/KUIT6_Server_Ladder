package Ladder.Ladder;

import Ladder.Creator.CustomLadderCreatorImpl;
import Ladder.Creator.RandomLadderCreatorImpl;

public class LadderGameFactory {
    private final LadderGame ladderGame;

    private LadderGameFactory(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public static LadderGame createCustomLadderGame(LadderSize ladderSize) {
        return new LadderGame(CustomLadderCreatorImpl.createEmptyLadder(ladderSize));
    }

    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        return new LadderGame(RandomLadderCreatorImpl.createRandomLadderCreator(ladderSize));
    }
}
