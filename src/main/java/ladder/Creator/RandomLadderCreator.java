package ladder.Creator;

import ladder.*;

import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    private final Row[] rows;

    public RandomLadderCreator(LadderSize ladderSize) {
        rows = new Row[ladderSize.getNumberOfRow().getNumber()];
        for (int i = 0; i < ladderSize.getNumberOfRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }

    public void createLadder(LadderSize ladderSize) {
        int lineNum = (int) (ladderSize.getNumberOfPerson().getNumber() * ladderSize.getNumberOfRow().getNumber() * 0.3);
        Random rand = new Random();
        int drawLineCount = 0;

        while (drawLineCount <= lineNum) {
            int row = rand.nextInt(ladderSize.getNumberOfRow().getNumber());
            int col = rand.nextInt(ladderSize.getNumberOfPerson().getNumber() - 1);
            try {
                drawLine(Position.from(row), Position.from(col));
                drawLineCount++;
            } catch (IllegalArgumentException e) {
                System.out.println("중복된 사다리 선이 존재합니다... 다시 시도합니다\n");
            }
        }
    }

    public Row[] getRows() {
        return rows;
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

}
