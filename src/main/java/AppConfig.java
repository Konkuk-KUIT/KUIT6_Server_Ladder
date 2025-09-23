import game.LadderGame;
import game.LadderGameFactory;
import observer.LadderObserver;
import runner.GameRunner;
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
        GameRunner gameRunner = game.getRunner();
        if (gameRunner instanceof LadderRunner ladderRunner) {
            LadderObserver printer = new LadderObserver();
            ladderRunner.addObserver(printer);
        }
    }
}