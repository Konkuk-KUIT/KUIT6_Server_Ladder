import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LadderGameFactoryTest {

    @Test
    @DisplayName("팩토리는 LadderGame 객체를 null이 아닌 상태로 생성해야 한다.")
    void createRandomLadderGame_shouldReturnNonNullInstance() {
        // when
        LadderGame game = LadderGameFactory.createRandomLadderGame(5, 7);

        // then
        assertNotNull(game, "LadderGame 객체는 null이 아니어야 합니다.");
    }
}