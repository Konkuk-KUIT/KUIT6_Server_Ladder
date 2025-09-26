import Ladder.Core.GreaterThanOne;
import Ladder.Core.Position;
import Ladder.Core.Row;
import Ladder.Creator.*;
import Ladder.Ladder.LadderGame;
import Ladder.Ladder.LadderGameFactory;
import Ladder.Ladder.LadderRunner;
import Ladder.Ladder.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrintLadderTest {

    @Test
    @DisplayName("정상 사다리 출력")
    void printingLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPeople = GreaterThanOne.from(4);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPeople);
        LadderCreator ladderCreator = CustomLadderCreatorImpl.createEmptyLadder(ladderSize);

        //when
        LadderGame ladderGame = LadderGameFactory.createCustomLadderGame(ladderSize);

        //then
        ladderGame.run(Position.from(0));

        //when
        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(0));
        ladderCreator.drawLine(Position.from(2), Position.from(2));

        //then
        ladderGame.run(Position.from(0));
    }

    @Test
    @DisplayName("랜덤 사다리 출력")
    void printRandom() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPeople = GreaterThanOne.from(4);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPeople);
        LadderCreator ladderCreator = RandomLadderCreatorImpl.createRandomLadderCreator(ladderSize);

        //when
        Row[] rows = ladderCreator.getRows();
        LadderRunner ladderRunner = new LadderRunner(rows);

        //then
        ladderRunner.run(Position.from(0));
    }

    @Test
    @DisplayName("랜덤 사다리 출력 팩토리 사용")
    void printRandomByFactory() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPeople = GreaterThanOne.from(4);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPeople);

        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        //then
        ladderGame.run(Position.from(0));
    }



}