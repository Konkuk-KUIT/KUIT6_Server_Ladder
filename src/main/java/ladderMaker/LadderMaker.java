package ladderMaker;

import domain.Ladder;
import domain.LadderNumber;

public interface LadderMaker {
    Ladder makeLadder(int row, int numberOfPerson);

    void validateLiner(int row, int numberOfPerson);

    void drawLine(LadderNumber left, LadderNumber right, int height);

    Ladder getLadder();

    int getNumberOfPerson();
}
