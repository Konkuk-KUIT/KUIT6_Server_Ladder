package domain;

public interface LadderMaker {

    Ladder makeLadder(int row, int numberOfPerson);
    void drawLine(int left, int right, int height);
}
