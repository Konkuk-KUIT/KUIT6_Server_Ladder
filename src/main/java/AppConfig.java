import board.Board;
import board.LadderBoard;
import runner.GameRunner;
import runner.LadderRunner;

public class AppConfig {
    
    public Board createBoard(int numberOfPerson, int height) {
        return new LadderBoard(numberOfPerson, height);
    }
    
    public GameRunner createRunner() {
        return new LadderRunner();
    }
    
    public Ladder createLadder(int numberOfPerson, int height) {
        return new Ladder(createBoard(numberOfPerson, height), createRunner());
    }
}