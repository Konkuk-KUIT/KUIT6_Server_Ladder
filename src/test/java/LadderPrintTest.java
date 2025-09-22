import domain.LadderGame;
import LadderMaker.Liner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderPrintTest {
    @Test
    @DisplayName("사다리타기 출력")
    void print_simple_ladder(){
        Liner liner = new Liner(5, 3);
        liner.drawLine(1, 2, 1);
        liner.drawLine(2, 3, 4);
        LadderGame ladderGame = LadderGame.from(liner);

        ladderGame.run(3);
    }

}
