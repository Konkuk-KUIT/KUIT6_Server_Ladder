package domain;

import validator.HeightValidator;
import validator.LadderNumberValidator;
import validator.LinerValidator;

import java.util.Random;

public class RandomLiner implements LadderMaker {
    private final int row;
    private final int numberOfPerson;
    private final Ladder ladder;
    private static Random rand = new Random();

    public RandomLiner(int row, int numberOfPerson) {
        LinerValidator.validateLiner(row, numberOfPerson);
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        this.ladder = makeLadder(this.row, this.numberOfPerson);
        makeRandomLine();
    }

    private void makeRandomLine() {
        int numberOfLines = (int) (row * numberOfPerson * 0.3);
        int i = 0;

        while (i < numberOfLines) {
            try {
                int left = rand.nextInt(numberOfPerson) + 1;
                int height = rand.nextInt(row) + 1;
                LadderNumberValidator.validateLadderNumber(left, numberOfPerson);
                HeightValidator.validateHeight(left, left + 1, ladder.getRows(), height);
                drawLine(left, left + 1, height);
                i++;
            } catch (RuntimeException e) {
                continue;
            }
        }
    }

    @Override
    public Ladder makeLadder(int row, int numberOfPerson) {
        return new Ladder(row, numberOfPerson);
    }

    @Override
    public void drawLine(int left, int right, int height) {
        ladder.drawLine(left, right, height, numberOfPerson);
    }

    @Override
    public Ladder getLadder() {
        return ladder;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }
}
