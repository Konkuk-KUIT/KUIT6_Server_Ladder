import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LadderConsolePrinterTest {

    @Test
    public void run() {
        rendersBeforeAndAfterStates();
    }

    // ... other tests or helper methods ...

    private void rendersBeforeAndAfterStates() {
        LadderCreator creator = new LadderCreator(1, 3);
        creator.placeBridge(0, 1);
        Ladder ladder = creator.toLadder();

        ByteArrayOutputStream capture = new ByteArrayOutputStream();
        LadderConsolePrinter printer = new LadderConsolePrinter(new PrintStream(capture));

        LadderRunner runner = new LadderRunner(ladder);
        runner.run(1, printer);

        String expected = String.join(System.lineSeparator(),
                "Before",
                "0   1* - 2",
                "",
                "After",
                "0   1 - 2*",
                "",
                "") ;

        Assertions.assertEquals(expected, capture.toString());
    }
}