import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.LadderGameFactory;
import ladder.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderFactoryTest {


    @Test
    @DisplayName("사다리 '줄수고정 랜덤자동' 생성 확인")
    void testCreateLadderByAutoInFactory() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame ladderGame = LadderGameFactory.auto(numberOfRow, numberOfPerson);

        //then
        ladderGame.run(Position.from(0));
    }

    @Test
    @DisplayName("사다리 '일반' 생성 확인")
    void testCreateLadderByNormalInFactory() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame ladderGame = LadderGameFactory.normal(numberOfRow, numberOfPerson);
        ladderGame.drawLine(Position.from(0), Position.from(1));
        ladderGame.drawLine(Position.from(2), Position.from(3));

        //then
        ladderGame.run(Position.from(0));
    }

    @Test
    @DisplayName("사다리 '확률고정 랜덤자동' 생성 확인")
    void testCreateLadderByAutoFixedInFactory() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame ladderGame = LadderGameFactory.autoFixed(numberOfRow, numberOfPerson);

        //then
        ladderGame.run(Position.from(0));
    }

    @Test
    @DisplayName("사다리 '랜덤자동'에서 임의로 drawLine() 시도")
    void testDrawLineByAutoInFactory() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame ladderGame = LadderGameFactory.autoFixed(numberOfRow, numberOfPerson);

        //then
        ladderGame.drawLine(Position.from(0), Position.from(0)); //drawLine은 빈 메서드임
        //ladderGame.run(Position.from(0));
    }
}
