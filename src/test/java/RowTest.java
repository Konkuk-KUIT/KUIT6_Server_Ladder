import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    @DisplayName("사다리 각 열이 초기값으로 CENTER가 들어있는지 테스트")
    public void initial_setting_success () throws Exception {

        //Given
        Row row = new Row(NaturalNumber.from(3));

        //When & Then
        for(LadderDirections direction : row.getLadderStates())
            assertEquals(LadderDirections.CENTER, direction);

    }

    @Test
    @DisplayName("사다리가 제대로 만들어지는지 테스트")
    public void draw_line_success () throws Exception {

        //Given
        Row row = new Row(NaturalNumber.from(3));

        //When
        row.drawLine(1);
        LadderDirections[] direction = row.getLadderStates();

        //Then
        assertEquals(LadderDirections.RIGHT, direction[1]);
        assertEquals(LadderDirections.LEFT, direction[2]);

    }

    @Test
    @DisplayName("라인이 겹치는 경우 예외처리 되는지 테스트")
    public void draw_overlapping_line_fail() throws Exception {
        // Given
        Row row = new Row(NaturalNumber.from(4));
        row.drawLine(1);
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(0));
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(2));
    }

}