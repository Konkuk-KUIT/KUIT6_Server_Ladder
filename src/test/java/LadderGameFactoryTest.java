import Ladder.Core.*;
import Ladder.Ladder.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameFactoryTest {

    @Test
    @DisplayName("서로 다른 인스턴스를 반환한다")
    void returnsDifferentInstances() {
        // given
        GreaterThanOne numberOfRow = GreaterThanOne.from(5);
        GreaterThanOne numberOfPeople = GreaterThanOne.from(6);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPeople);

        // when
        LadderGame first = LadderGameFactory.createRandomLadderGame(ladderSize);
        LadderGame second = LadderGameFactory.createRandomLadderGame(ladderSize);

        // then
        assertThat(first).isNotNull();
        assertThat(second).isNotNull();
        assertThat(first).isNotSameAs(second);
    }

    @Test
    @DisplayName("커스텀 정상 생성")
    void returnLadderGame() {
        GreaterThanOne numberOfRow = GreaterThanOne.from(5);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(6);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        //when
        LadderGame ladderGame = LadderGameFactory.createCustomLadderGame(ladderSize);

        //then
        assertThat(ladderGame).isNotNull();
    }

    //todo DI 테스트 방법?
}
