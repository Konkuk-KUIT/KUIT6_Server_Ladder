package game;

import laddercreator.NormalLadderCreator;
import laddercreator.RandomLadderCreator;
import board.Board;
import runner.GameRunner;
import runner.LadderRunner;
import wrap.PersonCount;
import wrap.LadderHeight;

public class LadderGameFactory {
    
    private LadderGameFactory() {
    }
    
    public static LadderGame createRandomLadderGame(PersonCount personCount, LadderHeight ladderHeight) {
        Board board = new RandomLadderCreator(personCount, ladderHeight);
        GameRunner runner = new LadderRunner();
        return new LadderGame(board, runner);
    }
    
    public static LadderGame createNormalLadderGame(PersonCount personCount, LadderHeight ladderHeight) {
        Board board = new NormalLadderCreator(personCount, ladderHeight);
        GameRunner runner = new LadderRunner();
        return new LadderGame(board, runner);
    }
}