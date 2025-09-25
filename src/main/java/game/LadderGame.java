package game;

import creator.LadderCreator;
import domain.LadderBoard;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public void run(LineNumber position) {
        LadderBoard board = ladderCreator.getBoard();
        board.run(position);
    }

    public LineNumberFactory getNumberFactory(){
        return ladderCreator.getNumberFactory();
    }
}
