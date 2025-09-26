import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RandomRungGeneratorTest {

    @Test
    @DisplayName("generate 실행 후 사다리는 연속된 가로선을 가지면 안 된다.")
    void generate_shouldNotCreateAdjacentRungs() {
        // given
        Ladder ladder = new Ladder(10, 20); // 충분히 큰 사다리
        RungGenerator generator = new RandomRungGenerator();

        // when
        generator.generate(ladder);

        // then
        for (int h = 0; h < ladder.getHeight(); h++) {
            for (int p = 0; p < ladder.getParticipantCount() - 2; p++) {
                // p 위치와 p+1 위치에 동시에 가로선이 있는지 검사
                boolean hasRungAtCurrent = ladder.hasRungAt(h, p);
                boolean hasRungAtNext = ladder.hasRungAt(h, p + 1);
                assertFalse(hasRungAtCurrent && hasRungAtNext,
                        "연속된 가로선이 발견되었습니다. 높이: " + h + ", 위치: " + p);
            }
        }
    }

    @Test
    @DisplayName("generate는 약속된 개수의 가로선을 생성해야 한다.")
    void generate_shouldCreateCorrectNumberOfRungs() {
        // given
        int participantCount = 6;
        int height = 10;
        Ladder ladder = new Ladder(participantCount, height);
        RungGenerator generator = new RandomRungGenerator();

        int expectedRungCount = (int) ((participantCount - 1) * height * 0.3);

        // when
        generator.generate(ladder);

        // then
        int actualRungCount = 0;
        for (int h = 0; h < height; h++) {
            for (int p = 0; p < participantCount - 1; p++) {
                if (ladder.hasRungAt(h, p)) {
                    actualRungCount++;
                }
            }
        }
        assertEquals(expectedRungCount, actualRungCount);
    }
}