package ladder.Creator;

import ladder.unit.LadderPosition;
import ladder.unit.LadderSize;
import ladder.unit.Position;
import ladder.unit.Row;

import java.util.HashSet;
import java.util.Random;

public class RandomLadderCreator implements LadderCreator {

    private final Row[] rows;
    private final LadderSize ladderSize;
    private HashSet hashSet = new HashSet<Integer>();

    public RandomLadderCreator(LadderSize ladderSize) {
        this.rows = CustomLadderCreator.createLadder(ladderSize);
        this.ladderSize = ladderSize;
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public void drawLine() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for (int i = 0; i < getRandomSize(); i++) {
            try {
                drawLine(getRandomPosition(random));
            } catch (Exception e) {
                i--;
            }
        }
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getRow()].drawLine(Position.from(ladderPosition.getPosition()));
    }

    private int getRandomNumber(Random random) {
        while(true) {
            int randomNumber = getRandom(random);
            if (!hashSet.contains(randomNumber)) {
               hashSet.add(randomNumber);
               return randomNumber;
            }
        }
    }

    private LadderPosition getRandomPosition(Random random) {
        int row = getRandomNumber(random) / ladderSize.getNumberOfPerson().getNumber();
        int column = getRandomNumber(random) % ladderSize.getNumberOfPerson().getNumber();
        return LadderPosition.of(row, Position.from(column));
    }

    private int getRandom(Random random) {
        return random.nextInt(ladderSize.getNumberOfRow().getNumber() * ladderSize.getNumberOfRow().getNumber());
    }

    private int getRandomSize() {
        return (int) Math.floor(ladderSize.getNumberOfRow().getNumber() * ladderSize.getNumberOfRow().getNumber() * 0.3);
    }
}
