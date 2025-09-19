import board.Board;
import board.LadderCreator;
import runner.GameRunner;
import runner.LadderRunner;
import wrap.PersonCount;
import wrap.LadderHeight;

public class AppConfig {
    
    public Board createBoard(PersonCount personCount, LadderHeight ladderHeight) {
        return new LadderCreator(personCount, ladderHeight);
    }
    
    public GameRunner createRunner() {
        return new LadderRunner();
    }
    
    public LadderGame createLadder(int numberOfPerson, int height) {
        PersonCount personCount = new PersonCount(numberOfPerson);
        LadderHeight ladderHeight = new LadderHeight(height);
        return new LadderGame(createBoard(personCount, ladderHeight), createRunner());
    }
}