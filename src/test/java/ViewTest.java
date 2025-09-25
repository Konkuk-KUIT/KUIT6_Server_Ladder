import ladder.Creator.NormalLadderCreator;
import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.LadderGameFactory;
import ladder.Position;
import ladder.View.LadderView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {

    @Test
    @DisplayName("사다리 ASCII 단일 출력 확인")
    void testViewLadderInASCII() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        NormalLadderCreator ladderCreator = new NormalLadderCreator(numberOfRow, numberOfPerson);
        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(0));

        //then
        LadderView.printASCII(ladderCreator.getRows(),0);
    }

    @Test
    @DisplayName("run() 메서드에서 사다리 ASCII 출력 확인")
    void testViewLadderInASCIIByRunMethod() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame ladderGame = LadderGameFactory.normal(numberOfRow, numberOfPerson);
        ladderGame.drawLine(Position.from(0),Position.from(0));
        ladderGame.drawLine(Position.from(1),Position.from(0));

        //then
        ladderGame.run(Position.from(0));
    }

    @Test
    @DisplayName("자동생성 사다리 run() 메서드에서 사다리 ASCII 출력 확인")
    void testViewLadderInASCIIByRunMethodInAuto() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(7);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame ladderGame = LadderGameFactory.auto(numberOfRow, numberOfPerson);

        //then
        ladderGame.run(Position.from(0));
    }
}
