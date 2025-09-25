import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LadderTest {

   @Test
   @DisplayName("주어진 사람수보다 큰 숫자에서 시작할 때 에러 발생")
   void throwInvalidStartPosition () {
       //given
       Position position = Position.from(4);

       //when
       GreaterThanOne numberOfPeople = GreaterThanOne.from(3);
       LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(2), numberOfPeople);
       LadderGame ladderGame = new LadderGame(ladderCreator);

       //then
       assertThatThrownBy(() -> ladderGame.runGame(position)).isInstanceOf(IllegalArgumentException.class);
   }

   @Test
   @DisplayName("사다리 게임이 제대로 동작하는지 확인")
   void testLadderGame () {
       //when
        GreaterThanOne numberOfPeople = GreaterThanOne.from(3);
        GreaterThanOne rows =  GreaterThanOne.from(4);
        LadderCreator ladderCreator = new LadderCreator(rows, numberOfPeople);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));
        ladderCreator.drawLine(Position.from(2), Position.from(1));

       //given
        Position position = Position.from(0);

       //then
       assertThat(ladderGame.runGame(position)).isEqualTo(1);
   }

}