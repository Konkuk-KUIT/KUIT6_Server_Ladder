package ladder;

import ladder.domain.GreaterThanOne;
import ladder.domain.Position;
import ladder.domain.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RowTest {

    @Test
    @DisplayName("한 칸 사다리 이동")
    void testOneStepLadderMovement() {
        // when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(2);
        Row row = new Row(numberOfPerson);

        // given
        Position position = Position.from(0);
        Position moved = row.moveNextPosition(position); // 반환값 받기

        // then
        assertThat(moved.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("두 칸 사다리 선 이동")
    void testTwoStepLadderLineMovement() {
        // when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        // given
        Position position = Position.from(0);
        Position moved = row.moveNextPosition(position);

        // then
        assertThat(moved.getValue()).isEqualTo(1);

        // given
        position = Position.from(1);
        moved = row.moveNextPosition(position);

        // then
        assertThat(moved.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("세 칸 사다리 선 이동")
    void testThreeStepLadderLineMovement() {
        // when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        // given
        Position moved = row.moveNextPosition(Position.from(0));
        assertThat(moved.getValue()).isEqualTo(1);

        moved = row.moveNextPosition(Position.from(1));
        assertThat(moved.getValue()).isEqualTo(0);

        moved = row.moveNextPosition(Position.from(2));
        assertThat(moved.getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("사다리 사람 수 예외 처리")
    void throwLadderPersonCountException() {
        assertThatThrownBy(() -> new Row(GreaterThanOne.from(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 최대 사람 수 초과 예외")
    void throwLadderExceedsMaxPersonCountException() {
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        Position position = Position.from(3);

        assertThatThrownBy(() -> row.moveNextPosition(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 그리기 위치 초과 예외")
    void throwLadderDrawingPositionExceedsLimitException() {
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        Position position = Position.from(3);

        assertThatThrownBy(() -> row.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class);
    }



    @Test
    @DisplayName("사다리 그리기 좌측 선 중복 예외")
    void throwLadderDrawingLeftLineDuplicateException() {
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        assertThatThrownBy(() -> row.drawLine(Position.from(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 그리기 우측 선 중복 예외")
    void throwLadderDrawingRightLineDuplicateException() {
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(1));

        assertThatThrownBy(() -> row.drawLine(Position.from(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가로줄 그리기")
    public void printRow() throws Exception {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(2));
        //when
        System.out.println(row);
        //then

     }
}
