package game;

import static org.junit.jupiter.api.Assertions.*;

import creator.CustomLadderCreator;
import domain.Ladder;
import domain.LadderSize;
import domain.NaturalNumber;
import domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("game.LadderGame 단위 테스트")
class LadderGameTest {

    private Ladder ladder;
    private LadderGame game;

    @BeforeEach
    void setUp() {
        //Given: 5행 4명의 참가자가 있는 사다리
        LadderSize size = new LadderSize(5, 4);
        CustomLadderCreator creator = new CustomLadderCreator(size);

        //라인 그리기
        creator.drawLine(0, 1);
        creator.drawLine(2, 0);
        creator.drawLine(3, 2);

        ladder = new Ladder(size, creator.getRows());
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
        LadderSize smallSize = new LadderSize(3, 3);
        CustomLadderCreator smallCreator = new CustomLadderCreator(smallSize);
        Ladder smallLadder = new Ladder(smallSize, smallCreator.getRows());
        LadderGame smallGame = new LadderGame(smallLadder);

        assertThrows(IllegalArgumentException.class,
                () -> smallGame.play(new NaturalNumber(0)));
        assertThrows(IllegalArgumentException.class,
                () -> smallGame.play(new NaturalNumber(4)));
    }
}
