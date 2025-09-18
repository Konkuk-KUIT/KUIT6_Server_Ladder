import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderBuilderTest {

    @Test
    @DisplayName("사다리 생성이 파라미터에 맞게 생성되었는지 테스트")
    public void ladder_size_correctly_build () throws Exception {

        // Given
        LadderBuilder builder = new LadderBuilder();
        Ladder ladder = builder.buildLadder(NaturalNumber.from(2), NaturalNumber.from(4));

        // When
        NaturalNumber rowCount = NaturalNumber.from(2);
        NaturalNumber numberOfPerson = NaturalNumber.from(4);

        // Then
        assertEquals(rowCount.getNumber(), ladder.getRows().length); // 행의 개수가 맞는지
        for (Row row : ladder.getRows()) {
            assertEquals(numberOfPerson.getNumber(), row.getLadderStates().length); // 각 행의 열 개수가 맞는지


        }
    }

    @Test
    @DisplayName("사다리 생성 초기값(CENTER)이 제대로 되었는지 확인")
    void ladder_correctly_build_center () throws Exception {
        // Given
        LadderBuilder builder = new LadderBuilder();
        Ladder ladder = builder.buildLadder(NaturalNumber.from(2), NaturalNumber.from(4));

        // When & Then
        for (Row row : ladder.getRows()) {
            for (LadderDirections directions : row.getLadderStates()) {
                assertEquals(LadderDirections.CENTER, directions);
            }
        }
    }
}