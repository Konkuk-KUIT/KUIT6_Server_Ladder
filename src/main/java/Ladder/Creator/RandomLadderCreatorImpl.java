package Ladder.Creator;

import Ladder.Core.GreaterThanOne;
import Ladder.Ladder.LadderSize;
import Ladder.Core.Position;
import Ladder.Core.Row;
import java.util.Random;

public class RandomLadderCreatorImpl implements LadderCreator {
    private final Row[] rows;
    private final LadderSize ladderSize;
    private final Random random = new Random();

    private RandomLadderCreatorImpl(LadderSize ladderSize) {
        this.ladderSize = ladderSize;

        rows = new Row[ladderSize.getNumberOfRow().getNumber()];
        createEmptyLadder(ladderSize.getNumberOfRow(), ladderSize.getNumberOfPerson());

        autoDrawLine(ladderSize);
    }

    public static RandomLadderCreatorImpl createRandomLadderCreator(LadderSize ladderSize) {
        return new RandomLadderCreatorImpl(ladderSize);
    }


    private void createEmptyLadder(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    private void autoDrawLine(LadderSize ladderSize) {
        drawLine(Position.from(ladderSize.getNumberOfRow().getNumber()),
                Position.from(ladderSize.getNumberOfPerson().getNumber()));
    }

    //기능 표현하는 메서드명으로
    @Override
    public void drawLine(Position row, Position col) {
        int target = ladderSize.randomCreatePolicyCount();
        int bound = ladderSize.getTotalSize() - 1;

        for (int i = 0; i < target; i++) {
            try {
                drawRandomLine(bound);
            } catch(Exception e){
                i--;
                continue;
            }
        }
    }

    private void drawRandomLine(int bound) {
        //todo HashSet 사용?
        int temp = random.nextInt(bound);
        int randomRow = temp / ladderSize.getNumberOfPerson().getNumber();
        int randomCol = temp % ladderSize.getNumberOfPerson().getNumber();
        rows[randomRow].drawLine(Position.from(randomCol));
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
