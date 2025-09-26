import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LadderGame 단위 테스트")
class LadderGameTest {

    private Ladder ladder;
    private LadderGame game;

    @BeforeEach
    void setUp() {
        // 기본 테스트용 사다리와 게임 생성
        ladder = new Ladder(new NaturalNumber(5), new NaturalNumber(4));
        ladder.drawLine(new NaturalNumber(1), new NaturalNumber(2));
        ladder.drawLine(new NaturalNumber(3), new NaturalNumber(1));
        ladder.drawLine(new NaturalNumber(4), new NaturalNumber(3));
        game = new LadderGame(ladder);
    }

    @Test
    @DisplayName("사다리 이동 결과 확인")
    void playSuccess() {
        assertEquals(2, game.play(new NaturalNumber(1)).value());
        assertEquals(3, game.play(new NaturalNumber(2)).value());
        assertEquals(4, game.play(new NaturalNumber(3)).value());
        assertEquals(1, game.play(new NaturalNumber(4)).value());
    }

    @Test
    @DisplayName("시작 위치 범위 초과 시 오류 발생")
    void playRangeException() {
        Ladder smallLadder = new Ladder(new NaturalNumber(3), new NaturalNumber(3));
        LadderGame smallGame = new LadderGame(smallLadder);

        assertThrows(IllegalArgumentException.class,
                () -> smallGame.play(new NaturalNumber(0)));
        assertThrows(IllegalArgumentException.class,
                () -> smallGame.play(new NaturalNumber(4)));
    }
}
