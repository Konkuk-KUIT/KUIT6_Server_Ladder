package ladderboard;
import ladderboard.LineDirection;
import position.Position;
import exceptions.InvalidCoordinateException;
import exceptions.DuplicateLineException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import wrap.LadderHeight;
import wrap.PersonCount;

import static org.junit.jupiter.api.Assertions.*;

class LadderCreatorTest {

    private LadderCreator board;

    @BeforeEach
    void setUp() {
        // Given: 4명이 참여하고 높이가 3인 사다리 보드
        PersonCount p = PersonCount.of(4);
        LadderHeight l = LadderHeight.of(3);
        board = new LadderCreator(p, l);
    }



    @Test
    void Y좌표가_음수이면_예외가_발생한다() {
        // Given: Y좌표가 음수인 좌표
        Position invalidCoordinate = Position.at(-1, 1);

        // When & Then: 예외가 발생한다
        assertThrows(InvalidCoordinateException.class, () -> {
            board.drawLine(invalidCoordinate);
        });
    }

    @Test
    void Y좌표가_높이를_초과하면_예외가_발생한다() {
        // Given: Y좌표가 높이를 초과하는 좌표
        Position invalidCoordinate = Position.at(3, 1);

        // When & Then: 예외가 발생한다
        assertThrows(InvalidCoordinateException.class, () -> {
            board.drawLine(invalidCoordinate);
        });
    }

    @Test
    void X좌표가_음수이면_예외가_발생한다() {
        // Given: X좌표가 음수인 좌표
        Position invalidCoordinate = Position.at(0, -1);

        // When & Then: 예외가 발생한다
        assertThrows(InvalidCoordinateException.class, () -> {
            board.drawLine(invalidCoordinate);
        });
    }

    @Test
    void X좌표가_허용범위를_초과하면_예외가_발생한다() {
        // Given: X좌표가 허용 범위를 초과하는 좌표 (4명이므로 가로선은 0-2까지만 가능)
        Position invalidCoordinate = Position.at(0, 3);

        // When & Then: 예외가 발생한다
        assertThrows(InvalidCoordinateException.class, () -> {
            board.drawLine(invalidCoordinate);
        });
    }

    @Test
    void 이미_선이_있는_곳에_다시_그으면_예외가_발생한다() {
        // Given: 이미 선이 그어진 좌표
        Position coordinate = Position.at(1, 1);
        board.drawLine(coordinate);

        // When & Then: 같은 위치에 다시 그으면 예외가 발생한다
        assertThrows(DuplicateLineException.class, () -> {
            board.drawLine(coordinate);
        });
    }

    @Test
    void 선이_없는_곳은_연결되지_않는다() {
        // Given: 빈 보드
        Position coordinate = Position.at(1, 1);

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

    // LineDirection 기능 테스트들
    @Test
    void 가로선이_없으면_NONE_방향을_반환한다() {
        // Given: 빈 보드
        Position position = Position.at(0, 1);

        // When
        LineDirection direction = board.getLineDirection(position);

        // Then
        assertEquals(LineDirection.NONE, direction);
    }

    @Test
    void 오른쪽으로_가는_가로선은_RIGHT_방향을_반환한다() {
        // Given: (0,1) 위치에 가로선 추가
        Position linePosition = Position.at(0, 1);
        board.drawLine(linePosition);

        // When
        LineDirection direction = board.getLineDirection(linePosition);

        // Then
        assertEquals(LineDirection.RIGHT, direction);
    }

    @Test
    void 왼쪽에서_오는_가로선은_LEFT_방향을_반환한다() {
        // Given: (0,1) 위치에 가로선 추가
        Position linePosition = Position.at(0, 1);
        board.drawLine(linePosition);

        // When: (0,2) 위치에서 방향 확인 (왼쪽에서 오는 선)
        Position rightPosition = Position.at(0, 2);
        LineDirection direction = board.getLineDirection(rightPosition);

        // Then
        assertEquals(LineDirection.LEFT, direction);
    }

    @Test
    void 범위를_벗어난_좌표는_NONE_방향을_반환한다() {
        // Given: 범위를 벗어난 좌표
        Position invalidPosition = Position.at(-1, 0);

        // When
        LineDirection direction = board.getLineDirection(invalidPosition);

        // Then
        assertEquals(LineDirection.NONE, direction);
    }

    @Test
    void LineDirection_값이_올바르게_설정되어_있다() {
        // Given & When & Then
        assertEquals(0, LineDirection.NONE.getValue());
        assertEquals(1, LineDirection.RIGHT.getValue());
        assertEquals(-1, LineDirection.LEFT.getValue());
    }

    @Test
    void 복잡한_사다리에서_각_위치의_방향이_올바르게_반환된다() {
        // Given: 복잡한 사다리 구성
        //   0 1 0 0
        //   0 0 1 0  
        //   0 0 0 0
        board.drawLine(Position.at(0, 1)); // 첫 번째 줄에 가로선
        board.drawLine(Position.at(1, 2)); // 두 번째 줄에 가로선

        // When & Then: 첫 번째 줄 검증
        assertEquals(LineDirection.NONE, board.getLineDirection(Position.at(0, 0)));   // 0
        assertEquals(LineDirection.RIGHT, board.getLineDirection(Position.at(0, 1)));  // 1 (오른쪽으로)
        assertEquals(LineDirection.LEFT, board.getLineDirection(Position.at(0, 2)));   // -1 (왼쪽에서)
        assertEquals(LineDirection.NONE, board.getLineDirection(Position.at(0, 3)));   // 0

        // When & Then: 두 번째 줄 검증
        assertEquals(LineDirection.NONE, board.getLineDirection(Position.at(1, 0)));   // 0
        assertEquals(LineDirection.NONE, board.getLineDirection(Position.at(1, 1)));   // 0
        assertEquals(LineDirection.RIGHT, board.getLineDirection(Position.at(1, 2)));  // 1 (오른쪽으로)
        assertEquals(LineDirection.LEFT, board.getLineDirection(Position.at(1, 3)));   // -1 (왼쪽에서)

        // When & Then: 세 번째 줄 검증 (모두 NONE)
        assertEquals(LineDirection.NONE, board.getLineDirection(Position.at(2, 0)));
        assertEquals(LineDirection.NONE, board.getLineDirection(Position.at(2, 1)));
        assertEquals(LineDirection.NONE, board.getLineDirection(Position.at(2, 2)));
        assertEquals(LineDirection.NONE, board.getLineDirection(Position.at(2, 3)));
    }
}