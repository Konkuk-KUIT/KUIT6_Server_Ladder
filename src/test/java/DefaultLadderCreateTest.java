import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DefaultLadderCreateTest {
    LadderGame ladderGame;

    @Test
    @DisplayName("사다리 생성 확인")
    void createLadder(){
        ladderGame = LadderGameFactory.createRandomLadderGame(7, 7);
        assertThat(ladderGame).isNotNull();
    }


//    LadderCreator ladderCreator;
//    Ladder ladder;
//
//    @BeforeEach
//    void setUp() {
//        ladderCreator = new LadderCreator(7, 7);
//    }
//
//    @Test
//    @DisplayName("사다리 생성 확인")
//    void createTest(){
//        assertThat(ladderCreator).isNotNull();
//    }
//
    @Test
    @DisplayName("사다리 연결")
    void drawAndShowLadder(){
        //LadderCreator 를 상속받은 RandomLadderCreator type을 반환함
        //createDefault~는 defaultCreator 를 만들어주는 LadderGame 을 반환함
        ladderGame = LadderGameFactory.createDefaultLadderGame(7, 7);
//        LadderCreator ladderCreator = ladderGame.getLadderCreator();
        ladderGame.drawLine(new Position(1, 2));
        ladderGame.drawLine(new Position(2, 3));
        ladderGame.drawLine(new Position(4, 0));
        ladderGame.drawLine(new Position(5, 5));
        Ladder ladder = new Ladder(ladderGame.getRows());
        ladder.showTotalLadder();
    }

}
