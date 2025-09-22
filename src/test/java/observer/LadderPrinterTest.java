package observer;

import laddercreator.NormalLadderCreator;
import board.Board;
import position.Position;
import wrap.LadderHeight;
import wrap.PersonCount;
import wrap.StartPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LadderPrinterTest {

    private LadderPrinter printer;
    private Board board;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        printer = new LadderPrinter();
        board = new NormalLadderCreator(PersonCount.of(4), LadderHeight.of(3));
        
        // 콘솔 출력을 캡처하기 위한 설정
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 게임_시작_메시지가_출력된다() {
        // Given
        StartPosition startPosition = StartPosition.at(0);

        // When
        printer.onGameStart(board, startPosition);

        // Then
        String output = outputStream.toString();
        assertTrue(output.contains("=== Ladder Game Start ==="));
        assertTrue(output.contains("Starting position: 0"));
    }

    @Test
    void 단계별_Before_메시지가_출력된다() {
        // Given
        printer.onGameStart(board, StartPosition.at(0));
        
        // When
        printer.onStepStart(Position.at(0, 1));

        // Then
        String output = outputStream.toString();
        assertTrue(output.contains("Before"));
    }

    @Test
    void 단계별_After_메시지가_출력된다() {
        // Given
        printer.onGameStart(board, StartPosition.at(0));
        
        // When
        printer.onStepComplete(Position.at(0, 2));

        // Then
        String output = outputStream.toString();
        assertTrue(output.contains("After"));
    }

    @Test
    void 게임_완료_메시지가_출력된다() {
        // Given
        Position finalPosition = Position.at(3, 2);

        // When
        printer.onGameComplete(finalPosition);

        // Then
        String output = outputStream.toString();
        assertTrue(output.contains("=== Game Complete ==="));
        assertTrue(output.contains("Final position: 2"));
    }

    @Test
    void 사다리와_플레이어_위치가_올바르게_출력된다() {
        // Given
        board = new NormalLadderCreator(PersonCount.of(3), LadderHeight.of(2));
        board.drawLine(Position.at(0, 1)); // 가로선 추가
        printer.onGameStart(board, StartPosition.at(0));
        
        // When
        printer.onStepStart(Position.at(0, 1));

        // Then
        String output = outputStream.toString();
        
        // 사다리 구조 확인 (0 1 0 형태로 출력되어야 함)
        assertTrue(output.contains("0 1* -1"));
        
        // 다음 줄은 빈 줄이므로 (0 0 0 형태)
        assertTrue(output.contains("0 0 0"));
    }

    @Test
    void 플레이어_위치에_별표가_표시된다() {
        // Given
        board = new NormalLadderCreator(PersonCount.of(3), LadderHeight.of(1));
        printer.onGameStart(board, StartPosition.at(0));
        
        // When  
        printer.onStepStart(Position.at(0, 2));

        // Then
        String output = outputStream.toString();
        assertTrue(output.contains("0 0 0*"));
    }
}