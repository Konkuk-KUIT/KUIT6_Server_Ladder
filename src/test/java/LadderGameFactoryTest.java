import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameFactoryTest {

    @Test
    @DisplayName("LadderGameFactory가 정상적으로 랜덤 사다리 게임을 실행하고 결과가 유효 범위 내에 있는지 확인")
    void testPlayRandomLadderGame() {
        // Given
        NaturalNumber height = NaturalNumber.from(10);
        NaturalNumber numberOfPeople = NaturalNumber.from(5);
        NaturalNumber startPosition = NaturalNumber.from(3);

        // When
        NaturalNumber result = LadderGameFactory.playRandomLadderGame(height, numberOfPeople, startPosition);

        // Then
        assertNotNull(result);
        assertTrue(result.getNumber() >= 1 && result.getNumber() <= numberOfPeople.getNumber(),
                ExceptionMessages.INVALID_RANGE_OF_LADDER.getMessage());
    }

    @Test
    @DisplayName("시작 위치가 참여 인원 범위를 벗어날 경우 예외 발생")
    void testPlayRandomLadderGameWithStartPositionOutOfBounds() {
        NaturalNumber height = NaturalNumber.from(10);
        NaturalNumber numberOfPeople = NaturalNumber.from(5);

        // 참여 인원 수보다 큰 값
        assertThrows(IllegalArgumentException.class, () -> {
            LadderGameFactory.playRandomLadderGame(height, numberOfPeople, NaturalNumber.from(numberOfPeople.getNumber() + 1));
        });
    }

    @Test
    @DisplayName("최소 유효값으로 게임 실행 시 정상 동작 및 결과 유효 범위 확인")
    void testPlayRandomLadderGameWithMinValidValues() {
        // Given
        NaturalNumber height = NaturalNumber.from(1);
        NaturalNumber numberOfPeople = NaturalNumber.from(2);
        NaturalNumber startPosition = NaturalNumber.from(1);

        // When
        NaturalNumber result = LadderGameFactory.playRandomLadderGame(height, numberOfPeople, startPosition);

        // Then
        assertNotNull(result);
        assertTrue(result.getNumber() >= 1 && result.getNumber() <= numberOfPeople.getNumber(),
                ExceptionMessages.INVALID_RANGE_OF_LADDER.getMessage());
    }
}