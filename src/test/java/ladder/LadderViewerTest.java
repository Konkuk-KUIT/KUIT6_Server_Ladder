package ladder;

import ladder.creator.CustomLadderCreator;
import ladder.position.LadderPosition;
import ladder.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderViewerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("기본 사다리 출력 확인")
    public void BasicLadderPrintTest() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        CustomLadderCreator ladderCreator = new CustomLadderCreator(numberOfRow, numberOfPerson);
        LadderViewer ladderViewer = new LadderViewer(ladderCreator.getRows());

        Position currentRow = Position.from(2);
        Position currentCol = Position.from(1);

        //when
        ladderViewer.printLadderStatus(LadderPosition.of(currentRow, currentCol), LadderLabel.BEFORE);

        //then
        String expectedOutput =
                "BEFORE\n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0* 0 0 \n" +
                        "0 0 0 0 \n\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);

        outContent.reset();

        //when
        ladderViewer.printLadderStatus(LadderPosition.of(currentRow, currentCol), LadderLabel.AFTER);

        //then
        expectedOutput =
                "AFTER\n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0* 0 0 \n" +
                        "0 0 0 0 \n\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

}