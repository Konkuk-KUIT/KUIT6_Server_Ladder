package LadderMaker;

import domain.Ladder;
import domain.LadderNumber;
import exception.IllegalLadderNumberException;
import exception.IllegalLinerException;

import java.util.Random;

public class RandomLiner implements LadderMaker {
    private final int row;
    private final int numberOfPerson;
    private final Ladder ladder;
    private static Random rand = new Random();

    public RandomLiner(int row, int numberOfPerson) {
        validateLiner(row, numberOfPerson);
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        this.ladder = makeLadder(this.row, this.numberOfPerson);
        makeRandomLine();
    }

    private void makeRandomLine() {
        int numberOfLines = (int) (row * numberOfPerson * RandomRatio.RANDOM_LINE.getValue());
        int madeLine = 0;
        while (madeLine < numberOfLines) {
            try {
                LadderNumber left = LadderNumber.from(rand.nextInt(numberOfPerson - 1) + 1);
                int height = rand.nextInt(row) + 1;
                validateLadderNumber(left);
                drawLine(left, LadderNumber.from(left.getNumber() + 1), height);
                madeLine++;
            } catch (RuntimeException e) {
            }
        }
    }

    @Override
    public void validateLiner(int row, int numberOfPerson) {
        if (row <= 0 || numberOfPerson <= 1)
            throw new IllegalLinerException();
    }

    @Override
    public Ladder makeLadder(int row, int numberOfPerson) {
        return new Ladder(row, numberOfPerson);
    }

    @Override
    public void drawLine(LadderNumber left, LadderNumber right, int height) {
        ladder.drawLine(left, right, height);
    }

    @Override
    public Ladder getLadder() {
        return ladder;
    }

    @Override
    public void validateLadderNumber(LadderNumber ladderNumber) {
        if (ladderNumber.getNumber() > numberOfPerson) {
            throw new IllegalLadderNumberException();
        }
    }
}
