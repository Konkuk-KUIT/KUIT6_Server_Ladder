import board.Board;
import board.LadderBoard;
import runner.GameRunner;
import runner.LadderRunner;
import wrap.PersonCount;
import wrap.LadderHeight;

public class AppConfig {
    
    public Board createBoard(PersonCount personCount, LadderHeight ladderHeight) {
        return new LadderBoard(personCount, ladderHeight);
    }
    
    public GameRunner createRunner() {
        return new LadderRunner();
    }
    
    public Ladder createLadder(int numberOfPerson, int height) {
        PersonCount personCount = new PersonCount(numberOfPerson);
        LadderHeight ladderHeight = new LadderHeight(height);
        return new Ladder(createBoard(personCount, ladderHeight), createRunner());
    }
}