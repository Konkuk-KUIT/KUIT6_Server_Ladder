package ladder.creator;

import ladder.LadderSize;
import ladder.Row;
import ladder.creator.util.RandomNumberGenerator;
import ladder.position.LadderPosition;
import ladder.position.Position;

import java.util.HashSet;

public class RandomLadderCreator implements LadderCreator{

    private  final LadderSize ladderSize;
    private final CustomLadderCreator customLadderCreator;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public RandomLadderCreator(CustomLadderCreator customLadderCreator) {
        this.ladderSize = customLadderCreator.getLadderSize();
        this.customLadderCreator = customLadderCreator;
        drawLines();
    }

    @Override
    @Deprecated
    public void drawLine(LadderPosition ladderPosition) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Row[] getRows() {
        return customLadderCreator.getRows();
    }

    private void drawLines() {
        HashSet<Integer> numbers = new HashSet<>();

        while (numbers.size() < numberOfLine()) {
            addNumber(numbers);
        }
    }

    private int numberOfLine() {
        return (int) (ladderSize.getSize() * 0.3);
    }

    private void addNumber(HashSet<Integer> numbers) {
        int number = randomNumberGenerator.getNumber(0, ladderSize.getSize() - 1);
        LadderPosition linePosition = numberToLadderPosition(number);

        try {
            customLadderCreator.drawLine(linePosition);
            numbers.add(number);
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    private LadderPosition numberToLadderPosition(int number) {
        Position row = Position.from(number / ladderSize.getNumberOfPersonValue());
        Position col = Position.from(number % ladderSize.getNumberOfPersonValue());
        return LadderPosition.of(row, col);
    }

}
