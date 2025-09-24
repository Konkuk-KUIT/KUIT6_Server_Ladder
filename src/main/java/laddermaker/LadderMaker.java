package laddermaker;

import domain.Ladder;
import domain.LadderNumber;

public interface LadderMaker {
    void validateLiner(int row, int numberOfPerson);

    void drawLine(LadderNumber left, LadderNumber right, int height);

    Ladder getLadder();

    int getNumberOfPerson();
}
