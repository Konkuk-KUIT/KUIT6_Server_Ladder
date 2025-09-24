import laddermaker.LadderMaker;
import domain.LadderNumber;
import game.LadderGame;
import laddermaker.Liner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderPrintTest {
    @Test
    @DisplayName("사다리타기 출력")
    void print_simple_ladder() {
        LadderMaker ladderMaker = new Liner(5, 3);
        ladderMaker.drawLine(LadderNumber.of(ladderMaker, 1), LadderNumber.of(ladderMaker, 2), 1);
        ladderMaker.drawLine(LadderNumber.of(ladderMaker, 2), LadderNumber.of(ladderMaker, 3), 4);
        LadderGame ladderGame = LadderGame.from(ladderMaker);

        ladderGame.run(LadderNumber.of(ladderMaker, 3));
    }

}
