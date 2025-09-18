import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(5));
    }

    @Test
    @DisplayName("선이 정상적으로 그려졌는지를 확인")
    public void draw_line_success () throws Exception {
        
        //When
        ladder.drawLine(NaturalNumber.from(2), NaturalNumber.from(3));
        LadderDirections[] directions = ladder.getRows()[2].getLadderStates();

        //Then
        assertEquals(LadderDirections.CENTER, directions[0]);
        assertEquals(LadderDirections.CENTER, directions[1]);
        assertEquals(LadderDirections.CENTER, directions[2]);
        assertEquals(LadderDirections.RIGHT, directions[3]);
        assertEquals(LadderDirections.LEFT, directions[4]);
    }
    
    @Test
    @DisplayName("사다리 수가 유효하지 않은 경우 테스트")
    public void numberOfLadder_valid () throws Exception {

        assertThrows(IllegalArgumentException.class, () -> new Ladder(NaturalNumber.from(0), NaturalNumber.from(3)));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(NaturalNumber.from(5), NaturalNumber.from(1)));
    }
    
}