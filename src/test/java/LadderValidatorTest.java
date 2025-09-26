import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderValidatorTest {

    @Test
    @DisplayName("참가자가 2명 미만일 때 Ladder 생성 시 예외가 발생해야 한다.")
    void createLadder_withLessThanTwoParticipants_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(1, 5);
        });
    }

    @Test
    @DisplayName("높이가 1 미만일 때 Ladder 생성 시 예외가 발생해야 한다.")
    void createLadder_withLessThanOneHeight_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(5, 0);
        });
    }
}