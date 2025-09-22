import game.LadderGame;
import game.LadderGameFactory;
import org.junit.jupiter.api.Test;
import wrap.LadderHeight;
import wrap.PersonCount;
import wrap.StartPosition;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameFactoryTest {

    @Test
    void createRandomLadderGame_호출시_RandomLadderCreator를_사용한_LadderGame을_생성한다() {
        PersonCount personCount = PersonCount.of(4);
        LadderHeight ladderHeight = LadderHeight.of(5);
        
        LadderGame game = LadderGameFactory.createRandomLadderGame(personCount, ladderHeight);
        
        assertNotNull(game);
        assertEquals(5, game.getBoard().getHeight());
        assertEquals(4, game.getBoard().getNumberOfPerson());
    }

    @Test
    void createNormalLadderGame_호출시_NormalLadderCreator를_사용한_LadderGame을_생성한다() {
        PersonCount personCount = PersonCount.of(3);
        LadderHeight ladderHeight = LadderHeight.of(4);
        
        LadderGame game = LadderGameFactory.createNormalLadderGame(personCount, ladderHeight);
        
        assertNotNull(game);
        assertEquals(4, game.getBoard().getHeight());
        assertEquals(3, game.getBoard().getNumberOfPerson());
    }

    @Test
    void RandomLadderGame이_정상적으로_실행되는지_확인() {
        PersonCount personCount = PersonCount.of(4);
        LadderHeight ladderHeight = LadderHeight.of(5);
        StartPosition startPosition = StartPosition.at(0);
        
        LadderGame game = LadderGameFactory.createRandomLadderGame(personCount, ladderHeight);
        
        assertDoesNotThrow(() -> {
            game.run(startPosition);
        });
    }

    @Test
    void 팩토리_메서드_패턴으로_의존성이_주입되는지_확인() {
        PersonCount personCount = PersonCount.of(5);
        LadderHeight ladderHeight = LadderHeight.of(3);
        
        LadderGame randomGame = LadderGameFactory.createRandomLadderGame(personCount, ladderHeight);
        LadderGame normalGame = LadderGameFactory.createNormalLadderGame(personCount, ladderHeight);
        
        assertNotNull(randomGame.getBoard());
        assertNotNull(normalGame.getBoard());
        
        assertNotSame(randomGame, normalGame);
    }
}