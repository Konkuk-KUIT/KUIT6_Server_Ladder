import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomLadderCreatorTest {

    @Test
    @DisplayName("랜덤 사다리가 조건에 맞게 생성되는지 확인")
    void testCreateRandomLadder() {
        // Given
        RandomLadderCreator creator = new RandomLadderCreator();
        NaturalNumber height = NaturalNumber.from(10);
        NaturalNumber numberOfPeople = NaturalNumber.from(5);

        // When
        Ladder ladder = creator.createLadder(height, numberOfPeople);

        // Then
        int expectedNumberOfLines = (int) (height.getNumber() * (numberOfPeople.getNumber() - 1) * 0.3);
        int actualNumberOfLines = 0;
        for (Row row : ladder.getRows()) {
            for (LadderDirections state : row.getLadderStates()) {
                if (state == LadderDirections.RIGHT) {
                    actualNumberOfLines++;
                }
            }
        }

        assertEquals(expectedNumberOfLines, actualNumberOfLines);
    }

    @Test
    @DisplayName("사람이 한 명일 때 라인이 생성되지 않는지 확인")
    void testCreateLadder_withOnePerson() {
        // Given
        RandomLadderCreator creator = new RandomLadderCreator();
        NaturalNumber height = NaturalNumber.from(10);
        NaturalNumber numberOfPeople = NaturalNumber.from(1);

        // When
        Ladder ladder = creator.createLadder(height, numberOfPeople);

        // Then
        int actualNumberOfLines = 0;
        for (Row row : ladder.getRows()) {
            for (LadderDirections state : row.getLadderStates()) {
                if (state == LadderDirections.RIGHT) {
                    actualNumberOfLines++;
                }
            }
        }
        assertEquals(0, actualNumberOfLines);
    }
}
