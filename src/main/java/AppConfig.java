import game.LadderGame;
import game.LadderGameFactory;
import observer.LadderPrinter;
import runner.LadderRunner;
import wrap.PersonCount;
import wrap.LadderHeight;

public class AppConfig {
    
    public LadderGame createNormalLadder(int numberOfPerson, int height) {
        PersonCount personCount = PersonCount.of(numberOfPerson);
        LadderHeight ladderHeight = LadderHeight.of(height);
        
        LadderGame game = LadderGameFactory.createNormalLadderGame(personCount, ladderHeight);
        setupObservers(game);
        return game;
    }

    public LadderGame createRandomLadder(int numberOfPerson, int height) {
        PersonCount personCount = PersonCount.of(numberOfPerson);
        LadderHeight ladderHeight = LadderHeight.of(height);
        
        LadderGame game = LadderGameFactory.createRandomLadderGame(personCount, ladderHeight);
        setupObservers(game);
        return game;
    }
    
    private void setupObservers(LadderGame game) {
        LadderRunner runner = (LadderRunner) game.getRunner();
        LadderPrinter printer = new LadderPrinter();
        runner.addObserver(printer);
    }
}