package runner;

import board.Board;
import board.LadderCreator;
import position.Position;
import exceptions.InvalidStartPositionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import wrap.LadderHeight;
import wrap.PersonCount;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameRunnerTest {

    private LadderRunner runner;
    private Board board;

    @BeforeEach
    void setUp() {
        runner = new LadderRunner();
        // Given: 4명이 참여하고 높이가 3인 사다리 보드
        PersonCount personCount = new PersonCount(4);
        LadderHeight ladderHeight = new LadderHeight(3);
        board = new LadderCreator(personCount, ladderHeight);
    }

    @Test
    void 가로선이_없으면_그대로_내려간다() {
        // Given: 가로선이 없는 빈 보드
        int startPosition = 1;

        // When: 게임을 실행한다
        int result = runner.run(board, startPosition);

        // Then: 시작 위치와 동일한 위치에 도착한다
        assertEquals(1, result);
    }

    @Test
    void 가로선을_만나면_오른쪽으로_이동한다() {
        // Given: (0,1) 위치에 가로선이 있는 보드
        board.drawLine(new Position(0, 1));
        int startPosition = 1;

        // When: 1번 위치에서 시작한다
        int result = runner.run(board, startPosition);

        // Then: 2번 위치에 도착한다
        assertEquals(2, result);
    }

    @Test
    void 왼쪽에_가로선이_있으면_왼쪽으로_이동한다() {
        // Given: (0,0) 위치에 가로선이 있는 보드
        board.drawLine(new Position(0, 0));
        int startPosition = 1;

        // When: 1번 위치에서 시작한다
        int result = runner.run(board, startPosition);

        // Then: 0번 위치에 도착한다
        assertEquals(0, result);
    }

    @Test
    void 복잡한_사다리에서_올바르게_이동한다() {
        // Given: 여러 가로선이 있는 복잡한 보드
        //   |   |   |   |
        //   | - | - |   |  <- (0,0), (0,1)에 가로선
        //   |   | - |   |  <- (1,1)에 가로선
        //   |   |   | - |  <- (2,2)에 가로선
        board.drawLine(new Position(0, 0));
        board.drawLine(new Position(0, 1));
        board.drawLine(new Position(1, 1));
        board.drawLine(new Position(2, 2));
        int startPosition = 0;

        // When: 0번 위치에서 시작한다
        int result = runner.run(board, startPosition);

        // Then: 올바른 위치에 도착한다
        assertEquals(3, result);
    }

    @Test
    void 맨_왼쪽에서_시작해도_올바르게_동작한다() {
        // Given: (0,0)에 가로선이 있는 보드
        board.drawLine(new Position(0, 0));
        int startPosition = 0;

        // When: 0번 위치에서 시작한다
        int result = runner.run(board, startPosition);

        // Then: 1번 위치에 도착한다
        assertEquals(1, result);
    }

    @Test
    void 맨_오른쪽에서_시작해도_올바르게_동작한다() {
        // Given: 빈 보드
        int startPosition = 3; // 4명이므로 최대 인덱스는 3

        // When: 3번 위치에서 시작한다
        int result = runner.run(board, startPosition);

        // Then: 3번 위치에 도착한다
        assertEquals(3, result);
    }

    @Test
    void 시작위치가_음수이면_예외가_발생한다() {
        // Given: 음수인 시작 위치
        int invalidStartPosition = -1;

        // When & Then: 예외가 발생한다
        assertThrows(InvalidStartPositionException.class, () -> {
            runner.run(board, invalidStartPosition);
        });
    }

    @Test
    void 시작위치가_사람수를_초과하면_예외가_발생한다() {
        // Given: 사람 수를 초과하는 시작 위치
        int invalidStartPosition = 4; // 4명이므로 최대 인덱스는 3

        // When & Then: 예외가 발생한다
        assertThrows(InvalidStartPositionException.class, () -> {
            runner.run(board, invalidStartPosition);
        });
    }

    @Test
    void 보드가_null이면_예외가_발생한다() {
        // Given: null 보드
        Board nullBoard = null;

        // When & Then: 예외가 발생한다
        assertThrows(IllegalArgumentException.class, () -> {
            runner.run(nullBoard, 0);
        });
    }
}