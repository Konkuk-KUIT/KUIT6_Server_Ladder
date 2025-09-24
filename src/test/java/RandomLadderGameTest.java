import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLadderGameTest {
    @Test
    @DisplayName("run - with drawLine")
    public void runDrawline() {
        LadderCreator ladderCreator = new RandomLadderCreator(GreaterThanOne.from(4), GreaterThanOne.from(4));
        LadderGame ladder = new LadderGame(ladderCreator);
        ladder.run(Position.from(0));

//                Assertions.assertEquals(1, ));
//        Assertions.assertEquals(2, ladder.run(Position.from(1)));
//        Assertions.assertEquals(3, ladder.run(Position.from(2)));
//        Assertions.assertEquals(0, ladder.run(Position.from(3)));
    }
}