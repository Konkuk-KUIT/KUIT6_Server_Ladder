package creator;

import domain.LadderBoard;
import game.LineNumber;
import game.LineNumberFactory;
import game.LineRange;

public interface LadderCreator {

    void drawLine(LineNumber position);

    LadderBoard getBoard();

    LineNumberFactory getNumberFactory();

}
