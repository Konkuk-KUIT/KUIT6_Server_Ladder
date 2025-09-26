package test.java;

import ladder.core.LadderGame;
import ladder.core.Row;
import ladder.creator.LadderGameFactory;
import ladder.creator.LadderSize;
import ladder.creator.RandomLadderCreator;
import ladder.util.GreaterThanOne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomLadderCreatorTest {

    @Test
    @DisplayName("랜덤 사다리는 정책상 (행*열*0.3) 만큼의 라인을 생성한다")
    void randomLadder_generates_expected_lines() {
        //given
        LadderSize size = new LadderSize(GreaterThanOne.from(10), GreaterThanOne.from(5)); // 10*5*0.3=15
        LadderGame game = LadderGameFactory.randomLadderGame(size,42L);

        //when
        int actual = 0;
        for (Row row : game.getRows()) {
            actual += row.countLines(); // 시작점만 세는 안전한 카운트
        }
        int expected = size.targetLines();


        //then
        assertThat(actual).isEqualTo(expected);
    }



    @Test
    @DisplayName("랜덤 사다리는 연속된 선을 생성할 수 없다")
    void randomLadder_has_no_sequence_lines() {
        // given
        LadderSize size = new LadderSize(GreaterThanOne.from(12), GreaterThanOne.from(8));
        long seed = 4242L;
        LadderGame game = LadderGameFactory.randomLadderGame(size, seed);

        // when & then
        Row[] rows = game.getRows();
        for (int r = 0; r < rows.length; r++) {
            String line = rows[r].renderLine(null);
            assertThat(line.contains("-1 -1"))
                    .as("row %s 에 연속 가로선이 생성됨: [%s]", r, line)
                    .isFalse();
        }
    }

    }



