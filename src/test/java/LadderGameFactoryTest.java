import ladder.core.LadderGame;
import ladder.core.LadderGameFactory;
import ladder.core.LadderSize;
import ladder.creator.CustomLadderCreator;
import ladder.position.LadderPosition;
import ladder.position.Position;
import ladder.util.GreaterThanOne;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderGameFactoryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        // 테스트 시작 전에 표준 출력을 outContent로 변경
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        // 테스트가 끝나면 표준 출력을 원래대로 복원
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("CustomLadderGame 생성, 실행, 출력 테스트")
    void customLadderGame_Test() {
        // given
        GreaterThanOne height = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = LadderSize.of(height, numberOfPerson);

        CustomLadderCreator customLadderCreator = new CustomLadderCreator(ladderSize);
        customLadderCreator.drawLine(LadderPosition.of(Position.from(0), Position.from(0)));
        customLadderCreator.drawLine(LadderPosition.of(Position.from(1), Position.from(2)));

        LadderGame ladderGame = new LadderGame(customLadderCreator); // 제어된 Creator로 게임 생성

        // when
        int result = ladderGame.run(Position.from(1));

        // then
        assertThat(result).isEqualTo(0);

        String expectedOutput =
                "BEFORE\n" +
                        "1 -1* 0 0 \n" +
                        "0 0 1 -1 \n" +
                        "0 0 0 0 \n\n" +
                        "AFTER\n" +
                        "1* -1 0 0 \n" +
                        "0 0 1 -1 \n" +
                        "0 0 0 0 \n\n" +
                        "BEFORE\n" +
                        "1 -1 0 0 \n" +
                        "0* 0 1 -1 \n" +
                        "0 0 0 0 \n\n" +
                        "AFTER\n" +
                        "1 -1 0 0 \n" +
                        "0* 0 1 -1 \n" +
                        "0 0 0 0 \n\n" +
                        "BEFORE\n" +
                        "1 -1 0 0 \n" +
                        "0 0 1 -1 \n" +
                        "0* 0 0 0 \n\n" +
                        "AFTER\n" +
                        "1 -1 0 0 \n" +
                        "0 0 1 -1 \n" +
                        "0* 0 0 0 \n\n";

        assertThat(outContent.toString().replace("\r\n", "\n")).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("RandomLadderGame 생성, 실행, 출력 테스트")
    void randomLadderGame_Test() {
        // given
        GreaterThanOne height = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = LadderSize.of(height, numberOfPerson);

        // when
        LadderGame randomLadderGame = LadderGameFactory.randomLadderGame(ladderSize);
        int result = randomLadderGame.run(Position.from(2)); // 2번 참가자부터 시작

        // then
        assertThat(result).isBetween(0, 4);

        String output = outContent.toString();
        assertThat(output).isNotEmpty();
        assertThat(output).contains("BEFORE", "AFTER");
    }

}