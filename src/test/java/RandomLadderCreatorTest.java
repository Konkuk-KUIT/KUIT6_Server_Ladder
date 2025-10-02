import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomLadderCreatorTest {

    public void run() {
        generatesRequestedAmountWithoutAdjacentLines();
    }

    @Test
    private void generatesRequestedAmountWithoutAdjacentLines() {
        int height = 4;
        int numberOfPerson = 5;
        Random random = new Random(1234L);

        RandomLadderCreator creator = new RandomLadderCreator(height, numberOfPerson, random);

        Ladder ladder = creator.provide();

        int availableColumns = numberOfPerson - 1;
        int expectedLines = (int) Math.round(height * availableColumns * 0.3);
        int actualLines = 0;
        for (Row row : ladder.getRows()) {
            for (int column = 0; column < availableColumns; column++) {
                if (row.connectsToRightFrom(column)) {
                    actualLines++;
                    Assertions.assertFalse(column < availableColumns - 1 && row.connectsToRightFrom(column + 1));
                }
            }
        }

        Assertions.assertTrue(actualLines <= expectedLines);
        if (expectedLines > 0) {
            Assertions.assertTrue(actualLines > 0);
        } else {
            Assertions.assertEquals(0, actualLines);
        }
    }
}