import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    @DisplayName("정상적으로 사다리게임이 실행되는지 확인")
    public void game_success () throws Exception {

        //Given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(5));
        ladder.drawLine(NaturalNumber.from(1), NaturalNumber.from(1));
        ladder.drawLine(NaturalNumber.from(2), NaturalNumber.from(3));
        LadderGame game = new LadderGame();

        //When & Then
        assertDoesNotThrow(() -> game.runGame(ladder, NaturalNumber.from(1)));
        assertDoesNotThrow(() -> game.runGame(ladder, NaturalNumber.from(2)));
        assertDoesNotThrow(() -> game.runGame(ladder, NaturalNumber.from(3)));
        assertDoesNotThrow(() -> game.runGame(ladder, NaturalNumber.from(4)));
        assertDoesNotThrow(() -> game.runGame(ladder, NaturalNumber.from(5)));

    }

    @Test
    @DisplayName("선택한 사다리 번호가 유효하지 경우 예외처리 확인")
    public void wrong_ladder_choice () throws Exception {

        //Given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(5));
        LadderGame game = new LadderGame();

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> game.runGame(ladder, NaturalNumber.from(0)));
        assertThrows(IllegalArgumentException.class, () -> game.runGame(ladder, NaturalNumber.from(-1)));
        assertThrows(IllegalArgumentException.class, () -> game.runGame(ladder, NaturalNumber.from(7)));
    }

    @Test
    @DisplayName("사람이 한 명일 때 테스트")
    public void one_person () throws Exception {

        //Given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(1));
        LadderGame game = new LadderGame();
        //When & Then
        assertEquals(1, game.runGame(ladder, NaturalNumber.from(1)).getNumber());

    }
}