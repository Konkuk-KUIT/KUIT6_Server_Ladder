import ladder.Creator.NormalLadderCreator;
import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.Position;
import ladder.View.LadderView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {

    @Test
    @DisplayName("사다리 Raw 출력 확인")
    void testViewAboutCreatedLadderInRaw() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);



        //when
        NormalLadderCreator ladderCreator = new NormalLadderCreator(numberOfRow, numberOfPerson);
        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(0));

        LadderGame ladderGame = new LadderGame(ladderCreator);
        System.out.println(ladderGame.run(Position.from(0)));
        //then
        LadderView.printASCII(ladderCreator.getRows(),0,0);
    }

    @Test
    @DisplayName("사다리 Raw 출력 확인")
    void testViewAboutCreatedLadderInASCII() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);



        //when
        NormalLadderCreator ladderCreator = new NormalLadderCreator(numberOfRow, numberOfPerson);
        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(0));

        LadderGame ladderGame = new LadderGame(ladderCreator);
        System.out.println(ladderGame.run(Position.from(0)));
        //then
        LadderView.printASCII(ladderCreator.getRows(),0,0);
    }
}
