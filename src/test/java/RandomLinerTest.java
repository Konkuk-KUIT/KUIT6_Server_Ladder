import domain.LadderNumber;
import game.LadderGame;
import ladderMaker.LadderMaker;
import ladderMaker.RandomLiner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLinerTest {
    @Test
    @DisplayName("3 x 6 랜덤 사다리타기 게임.")
    void random_liner_test(){
        LadderMaker ladderMaker = new RandomLiner(3,6);
        LadderGame ladderGame = LadderGame.from(ladderMaker);

        ladderGame.run(LadderNumber.of(ladderMaker,1));
    }
}
