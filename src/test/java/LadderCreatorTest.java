import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LadderCreatorTest {

    @Test
    @DisplayName("RandomLadderCreator가 성공적으로 생성됩니다.")
    void testCreateRandomLadder() {
        // given
        GreaterThanOne numberOfRow = GreaterThanOne.from(5);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);

        // when
        LadderCreator ladderCreator = new RandomLadderCreator(numberOfRow, numberOfPerson);

        // then
        assertThat(ladderCreator).isNotNull();
        assertThat(ladderCreator.getRows()).hasSize(5);
    }

    @Test
    @DisplayName("CustomLadderCreator가 성공적으로 생성됩니다.")
    void testCreateCustomLadder() {
        // given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);

        // when
        LadderCreator ladderCreator = new CustomLadderCreator(numberOfRow, numberOfPerson);

        // then
        assertThat(ladderCreator).isNotNull();
        assertThat(ladderCreator.getRows()).hasSize(3);
    }

    @Test
    @DisplayName("RandomLadderCreator는 자동으로 라인을 생성합니다.")
    void testRandomLadderGeneratesLines() {
        // given
        GreaterThanOne numberOfRow = GreaterThanOne.from(6);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        // when
        RandomLadderCreator ladderCreator = new RandomLadderCreator(numberOfRow, numberOfPerson);

        // then
        LadderLine[] rows = ladderCreator.getRows();
        boolean hasAnyLine = false;

        for (LadderLine row : rows) {
            for (Node node : row.getNodes()) {
                if (node.isAlreadySetDirection()) {
                    hasAnyLine = true;
                    break;
                }
            }
            if (hasAnyLine) break;
        }

        assertThat(hasAnyLine).isTrue();
    }
}