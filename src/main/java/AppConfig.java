import game.LadderGame;
import game.LadderGameFactory;
import observer.LadderObserver;
import observer.Subject;
import runner.GameRunner;
import wrap.PersonCount;
import wrap.LadderHeight;

public class AppConfig {
    
    public LadderGame createNormalLadder(int numberOfPerson, int height) {
        PersonCount personCount = PersonCount.from(numberOfPerson);
        LadderHeight ladderHeight = LadderHeight.from(height);
        
        LadderGame game = LadderGameFactory.createNormalLadderGame(personCount, ladderHeight);
        setupObservers(game);
        return game;
    }

    public LadderGame createRandomLadder(int numberOfPerson, int height) {
        PersonCount personCount = PersonCount.from(numberOfPerson);
        LadderHeight ladderHeight = LadderHeight.from(height);
        
        LadderGame game = LadderGameFactory.createRandomLadderGame(personCount, ladderHeight);
        setupObservers(game);
        return game;
    }
    
    private void setupObservers(LadderGame game) {
        GameRunner gameRunner = game.getRunner();
        if (gameRunner instanceof Subject subject) {
            LadderObserver printer = new LadderObserver();
            subject.addObserver(printer);
        }
    }
}