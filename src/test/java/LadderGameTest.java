import exceptions.InvalidCoordinateException;
import game.LadderGame;
import observer.Observer;
import position.Position;
import exceptions.InvalidStartPositionException;
import runner.LadderRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wrap.StartPosition;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class LadderGameTest {
    
    @Mock
    private Observer mockObserver;
    
    private LadderGame ladderGame;
    
    @Test
    void AppConfig를_통해_사다리를_생성할_수_있다() {
        // Given: AppConfig
        AppConfig config = new AppConfig();
        
        // When: 사다리를 생성한다
        LadderGame createdLadderGame = config.createNormalLadder(4, 5);
        
        // Then: 사다리가 정상적으로 생성된다
        assertNotNull(createdLadderGame);
    }
    
    @Test
    void null_좌표로_선을_그으면_예외가_발생한다() {
        // Given: 사다리와 null 좌표
        AppConfig config = new AppConfig();
        ladderGame = config.createNormalLadder(4, 3);
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
            StartPosition invalidStartPosition = StartPosition.at(-1);
        });
    }
    
    @Test
    void 전체_시나리오_테스트() {
        // Given: 실제 구현체를 사용한 통합 테스트
        AppConfig config = new AppConfig();
        LadderGame ladderGame = config.createNormalLadder(4, 3);
        
        // When: 사다리를 구성하고 게임을 실행한다
        ladderGame.drawLine(Position.at(0, 1)); // 첫 번째 줄에 가로선
        ladderGame.drawLine(Position.at(1, 0)); // 두 번째 줄에 가로선
        
        // Then: 각 시작 위치에서 올바른 결과가 나온다
        assertEquals(1, ladderGame.run(StartPosition.at(0)).getX()); // 0 -> 1
        assertEquals(2, ladderGame.run(StartPosition.at(1)).getX()); // 1 -> 2 -> 1
        assertEquals(0, ladderGame.run(StartPosition.at(2)).getX()); // 2 -> 1 -> 0
        assertEquals(3, ladderGame.run(StartPosition.at(3)).getX()); // 3 -> 3 -> 3
    }
    
    @Test
    void 정상적인_좌표로_선을_그을_수_있다() {
        // Given: 사다리와 유효한 좌표
        AppConfig config = new AppConfig();
        ladderGame = config.createNormalLadder(4, 3);
        Position coordinate = Position.at(1, 2);
        
        // When: 선을 그린다
        assertDoesNotThrow(() -> {
            ladderGame.drawLine(coordinate);
        });
        
        // Then: 게임 실행 시 영향을 받는다
        Position result = ladderGame.run(StartPosition.at(2));
        assertEquals(3, result.getX()); // 2번에서 시작해서 3번으로 이동
    }
    
    @Test
    void 정상적인_시작위치로_게임을_실행할_수_있다() {
        // Given: 사다리와 유효한 시작 위치
        AppConfig config = new AppConfig();
        ladderGame = config.createNormalLadder(4, 3);
        StartPosition startPosition = StartPosition.at(2);
        
        // When: 게임을 실행한다
        Position result = ladderGame.run(startPosition);
        
        // Then: 결과가 반환된다
        assertTrue(result.getX() >= 0 && result.getX() < 4);
    }

    // 시각화 통합 테스트들
    @Test
    void AppConfig로_생성된_게임에서_Observer가_자동으로_설정된다() {
        // Given: AppConfig로 생성된 게임 (Observer 자동 설정됨)
        AppConfig config = new AppConfig();
        ladderGame = config.createNormalLadder(4, 3);
        
        // Observer 테스트를 위해 추가 Mock Observer 등록
        LadderRunner runner = (LadderRunner) ladderGame.getRunner();
        runner.addObserver(mockObserver);

        // When: 게임 실행
        Position result = ladderGame.run(StartPosition.at(1));

        // Then: Observer가 호출되었는지 확인
        verify(mockObserver).onGameStart(any(), eq(StartPosition.at(1)));
        verify(mockObserver, times(3)).onStepStart(any(Position.class));
        verify(mockObserver, times(3)).onStepComplete(any(Position.class));
        verify(mockObserver).onGameComplete(result);
    }

    @Test
    void 복잡한_사다리에서_Observer가_올바른_이동경로를_추적한다() {
        // Given: 복잡한 사다리 설정
        AppConfig config = new AppConfig();
        ladderGame = config.createNormalLadder(4, 3);
        ladderGame.drawLine(Position.at(0, 1)); // 첫 번째 줄에 가로선
        ladderGame.drawLine(Position.at(1, 0)); // 두 번째 줄에 가로선

        // AppConfig에서 생성된 Runner 사용
        LadderRunner runner = (LadderRunner) ladderGame.getRunner();
        ArgumentCaptor<Position> stepCaptor = ArgumentCaptor.forClass(Position.class);
        runner.addObserver(mockObserver);

        // When: 0번 위치에서 시작
        Position result = ladderGame.run(StartPosition.at(0));

        // Then: 이동 경로가 올바르게 추적되는지 확인
        verify(mockObserver, times(3)).onStepComplete(stepCaptor.capture());
        
        // 최종적으로 1번 위치에 도착해야 함
        assertEquals(Position.at(3, 1), result);
    }

    @Test 
    void LadderPrinter와_실제_게임이_연동된다() {
        // Given: 실제 게임 설정 (AppConfig에서 LadderPrinter 자동 설정됨)
        AppConfig config = new AppConfig();
        ladderGame = config.createNormalLadder(3, 2);
        
        // 테스트를 위해 추가 Mock Observer 등록
        LadderRunner runner = (LadderRunner) ladderGame.getRunner();
        runner.addObserver(mockObserver);

        // When: 게임 실행
        Position result = ladderGame.run(StartPosition.at(1));

        // Then: 모든 Observer 메서드가 호출되었는지 확인
        verify(mockObserver).onGameStart(any(), eq(StartPosition.at(1)));
        verify(mockObserver, times(2)).onStepStart(any(Position.class)); // height만큼 호출
        verify(mockObserver, times(2)).onStepComplete(any(Position.class));
        verify(mockObserver).onGameComplete(result);
    }
    
    // RandomLadder 테스트들
    @Test
    void AppConfig를_통해_랜덤_사다리를_생성할_수_있다() {
        // Given: AppConfig
        AppConfig config = new AppConfig();
        
        // When: 랜덤 사다리를 생성한다
        LadderGame randomLadderGame = config.createRandomLadder(4, 5);
        
        // Then: 사다리가 정상적으로 생성된다
        assertNotNull(randomLadderGame);
        assertNotNull(randomLadderGame.getBoard());
        assertNotNull(randomLadderGame.getRunner());
    }
    
    @Test
    void 랜덤_사다리도_Observer가_자동으로_설정된다() {
        // Given: AppConfig로 생성된 랜덤 게임
        AppConfig config = new AppConfig();
        LadderGame randomGame = config.createRandomLadder(4, 3);
        
        // 테스트를 위해 추가 Mock Observer 등록
        LadderRunner runner = (LadderRunner) randomGame.getRunner();
        runner.addObserver(mockObserver);
        
        // When: 게임 실행
        Position result = randomGame.run(StartPosition.at(1));
        
        // Then: Observer가 호출되었는지 확인
        verify(mockObserver).onGameStart(any(), eq(StartPosition.at(1)));
        verify(mockObserver, times(3)).onStepStart(any(Position.class));
        verify(mockObserver, times(3)).onStepComplete(any(Position.class));
        verify(mockObserver).onGameComplete(result);
    }
    
    @Test
    void 랜덤_사다리에서_모든_시작위치가_유효한_결과를_반환한다() {
        // Given: 랜덤 사다리
        AppConfig config = new AppConfig();
        LadderGame randomGame = config.createRandomLadder(5, 4);
        
        // When & Then: 모든 시작 위치에서 게임 실행
        for (int startPos = 0; startPos < 5; startPos++) {
            Position result = randomGame.run(StartPosition.at(startPos));
            
            // 결과가 유효한 범위 내에 있는지 확인
            assertTrue(result.getX() >= 0 && result.getX() < 5, 
                "시작위치 " + startPos + "에서 결과 " + result.getX() + "는 유효하지 않음");
            assertEquals(4, result.getY(), "최종 높이는 보드 높이와 같아야 함");
        }
    }
    
    @Test
    void 동일한_설정으로_생성된_랜덤_사다리들은_서로_다를_수_있다() {
        // Given: 동일한 설정으로 여러 랜덤 사다리 생성
        AppConfig config = new AppConfig();
        LadderGame game1 = config.createRandomLadder(4, 3);
        LadderGame game2 = config.createRandomLadder(4, 3);
        
        // When: 같은 시작 위치에서 실행
        Position result1 = game1.run(StartPosition.at(1));
        Position result2 = game2.run(StartPosition.at(1));
        
        // Then: 결과가 다를 수 있음 (랜덤이므로 항상 다른 건 아니지만, 적어도 에러는 발생하지 않아야 함)
        assertNotNull(result1);
        assertNotNull(result2);
        assertTrue(result1.getX() >= 0 && result1.getX() < 4);
        assertTrue(result2.getX() >= 0 && result2.getX() < 4);
    }
}