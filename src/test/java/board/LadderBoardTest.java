package board;
import position.Position;
import exceptions.InvalidCoordinateException;
import exceptions.DuplicateLineException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import wrap.LadderHeight;
import wrap.PersonCount;

import static org.junit.jupiter.api.Assertions.*;

class LadderBoardTest {

    private LadderBoard board;

    @BeforeEach
    void setUp() {
        // Given: 4명이 참여하고 높이가 3인 사다리 보드
        PersonCount p = new PersonCount(4);
        LadderHeight l = new LadderHeight(3);
        board = new LadderBoard(p, l);
    }

    @Test
    void 정상적인_좌표에_선을_그을_수_있다() {
        // Given: 유효한 좌표
        Position coordinate = new Position(0, 1);

        // When: 선을 그린다
        board.drawLine(coordinate);

        // Then: 해당 위치에 연결이 생성된다
        assertTrue(board.hasConnection(coordinate));
    }

    @Test
    void Y좌표가_음수이면_예외가_발생한다() {
        // Given: Y좌표가 음수인 좌표
        Position invalidCoordinate = new Position(-1, 1);

        // When & Then: 예외가 발생한다
        assertThrows(InvalidCoordinateException.class, () -> {
            board.drawLine(invalidCoordinate);
        });
    }

    @Test
    void Y좌표가_높이를_초과하면_예외가_발생한다() {
        // Given: Y좌표가 높이를 초과하는 좌표
        Position invalidCoordinate = new Position(3, 1);

        // When & Then: 예외가 발생한다
        assertThrows(InvalidCoordinateException.class, () -> {
            board.drawLine(invalidCoordinate);
        });
    }

    @Test
    void X좌표가_음수이면_예외가_발생한다() {
        // Given: X좌표가 음수인 좌표
        Position invalidCoordinate = new Position(0, -1);

        // When & Then: 예외가 발생한다
        assertThrows(InvalidCoordinateException.class, () -> {
            board.drawLine(invalidCoordinate);
        });
    }

    @Test
    void X좌표가_허용범위를_초과하면_예외가_발생한다() {
        // Given: X좌표가 허용 범위를 초과하는 좌표 (4명이므로 가로선은 0-2까지만 가능)
        Position invalidCoordinate = new Position(0, 3);

        // When & Then: 예외가 발생한다
        assertThrows(InvalidCoordinateException.class, () -> {
            board.drawLine(invalidCoordinate);
        });
    }

    @Test
    void 이미_선이_있는_곳에_다시_그으면_예외가_발생한다() {
        // Given: 이미 선이 그어진 좌표
        Position coordinate = new Position(1, 1);
        board.drawLine(coordinate);

        // When & Then: 같은 위치에 다시 그으면 예외가 발생한다
        assertThrows(DuplicateLineException.class, () -> {
            board.drawLine(coordinate);
        });
    }

    @Test
    void 선이_없는_곳은_연결되지_않는다() {
        // Given: 빈 보드
        Position coordinate = new Position(1, 1);

        // When: 아무것도 하지 않는다

        // Then: 연결이 없다
        assertFalse(board.hasConnection(coordinate));
    }

    @Test
    void 보드의_높이와_사람수를_확인할_수_있다() {
        // Given: 4명, 높이 3인 보드

        // When & Then: 정확한 값을 반환한다
        assertEquals(3, board.getHeight());
        assertEquals(4, board.getNumberOfPerson());
    }
}