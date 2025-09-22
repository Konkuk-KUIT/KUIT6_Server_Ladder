import domain.LadderGame;
import domain.LadderMaker;
import domain.RandomLiner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLinerTest {
    @Test
    @DisplayName("")
    void random_liner_test(){
        LadderMaker ladderMaker = new RandomLiner(3,6);
        LadderGame ladderGame = LadderGame.from(ladderMaker);

        ladderGame.run(1);
    }
}
