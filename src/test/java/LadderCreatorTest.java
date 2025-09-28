import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderCreatorTest {
    @Test
    @DisplayName("사다리 생성 테스트")
    void createLadder () {
        //given
        GreaterThanOne numberOfPeople = GreaterThanOne.from(3);
        GreaterThanOne rows = GreaterThanOne.from(5);
        //when
        LadderCreator ladderCreator = new LadderCreator(rows, numberOfPeople);
        //then
        assertThat(ladderCreator).isNotNull();
    }
    
    @Test
    @DisplayName("랜덤으로 라인 생성")
    void randomCreateLine () throws Exception {
        //given
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(4), GreaterThanOne.from(5));
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderCreator);
        //when
        ladderCreator.randomDrawLine();
        PrintLadder printLadder = new PrintLadder(ladderCreator);
        //then
        printLadder.print(Position.from(0));
    }
}