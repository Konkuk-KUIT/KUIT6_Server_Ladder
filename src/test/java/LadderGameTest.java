import exceptions.InvalidCoordinateException;
import position.Position;
import exceptions.InvalidStartPositionException;
import org.junit.jupiter.api.Test;
import wrap.StartPosition;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    
    private LadderGame ladderGame;
    
    @Test
    void AppConfig를_통해_사다리를_생성할_수_있다() {
        // Given: AppConfig
        AppConfig config = new AppConfig();
        
        // When: 사다리를 생성한다
        LadderGame createdLadderGame = config.createLadder(4, 5);
        
        // Then: 사다리가 정상적으로 생성된다
        assertNotNull(createdLadderGame);
    }
    
    @Test
    void null_좌표로_선을_그으면_예외가_발생한다() {
        // Given: 사다리와 null 좌표
        AppConfig config = new AppConfig();
        ladderGame = config.createLadder(4, 3);
        Position nullCoordinate = null;
        
        // When & Then: 예외가 발생한다
        assertThrows(InvalidCoordinateException.class, () -> {
            ladderGame.drawLine(nullCoordinate);
        });
    }
    
    @Test
    void 음수_시작위치로_게임을_실행하면_예외가_발생한다() {
        // Given & When & Then: 예외가 발생한다
        assertThrows(InvalidStartPositionException.class, () -> {
            StartPosition invalidStartPosition = new StartPosition(-1);
        });
    }
    
    @Test
    void 전체_시나리오_테스트() {
        // Given: 실제 구현체를 사용한 통합 테스트
        AppConfig config = new AppConfig();
        LadderGame ladderGame = config.createLadder(4, 3);
        
        // When: 사다리를 구성하고 게임을 실행한다
        ladderGame.drawLine(new Position(0, 1)); // 첫 번째 줄에 가로선
        ladderGame.drawLine(new Position(1, 0)); // 두 번째 줄에 가로선
        
        // Then: 각 시작 위치에서 올바른 결과가 나온다
        assertEquals(1, ladderGame.run(new StartPosition(0)).getX()); // 0 -> 1
        assertEquals(2, ladderGame.run(new StartPosition(1)).getX()); // 1 -> 2 -> 1
        assertEquals(0, ladderGame.run(new StartPosition(2)).getX()); // 2 -> 1 -> 0
        assertEquals(3, ladderGame.run(new StartPosition(3)).getX()); // 3 -> 3 -> 3
    }
    
    @Test
    void 정상적인_좌표로_선을_그을_수_있다() {
        // Given: 사다리와 유효한 좌표
        AppConfig config = new AppConfig();
        ladderGame = config.createLadder(4, 3);
        Position coordinate = new Position(1, 2);
        
        // When: 선을 그린다
        assertDoesNotThrow(() -> {
            ladderGame.drawLine(coordinate);
        });
        
        // Then: 게임 실행 시 영향을 받는다
        Position result = ladderGame.run(new StartPosition(2));
        assertEquals(3, result.getX()); // 2번에서 시작해서 3번으로 이동
    }
    
    @Test
    void 정상적인_시작위치로_게임을_실행할_수_있다() {
        // Given: 사다리와 유효한 시작 위치
        AppConfig config = new AppConfig();
        ladderGame = config.createLadder(4, 3);
        StartPosition startPosition = new StartPosition(2);
        
        // When: 게임을 실행한다
        Position result = ladderGame.run(startPosition);
        
        // Then: 결과가 반환된다
        assertTrue(result.getX() >= 0 && result.getX() < 4);
    }
}