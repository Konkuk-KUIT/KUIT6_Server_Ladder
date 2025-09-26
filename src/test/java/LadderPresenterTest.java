import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LadderPresenterTest {

    // System.out 출력을 캡처하기 위한 설정
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("printState는 제목, 가로선, 참가자 위치(*)를 포함하여 출력해야 한다.")
    void printState_shouldContainTitleRungAndPositionMarker() {
        // given
        Ladder ladder = new Ladder(4, 3);
        ladder.drawLine(1, 1); // 1층, 1-2 연결
        LadderPresenter presenter = new LadderPresenter();

        // when: 1층 높이에서 2번 참가자(0-based index: 1)의 위치를 출력
        presenter.printState(ladder, 0, 1, "Test Title");

        // then
        String output = outContent.toString();
        assertTrue(output.contains("Test Title"), "출력에 제목이 포함되어야 합니다.");
        assertTrue(output.contains("|-----|     |     |"), "출력에 가로선이 포함되어야 합니다.");
        assertTrue(output.contains("2*"), "출력에 현재 참가자 위치(*)가 포함되어야 합니다.");
    }
}