package creator;

import domain.LadderBoard;
import drawLineStrategy.DrawLineStrategy;
import drawLineStrategy.DrawLineStrategyFactory;
import game.LineNumber;
import game.LineNumberFactory;
import game.LineRange;
import util.NaturalNumber;

public class NormalLadderCreator implements LadderCreator{

    private final LadderBoard board;
    private final LineRange range;
    private final LineNumberFactory numberFactory;

    public NormalLadderCreator(NaturalNumber row, NaturalNumber numberOfPerson) {
        range = LineRange.getInstance(numberOfPerson);
        numberFactory = LineNumberFactory.getInstance(range);
        board = new LadderBoard(row, numberOfPerson);
    }

    public void drawLine(LineNumber position) {
        DrawLineStrategy drawLineStrategy = DrawLineStrategyFactory.getInstance(position.getDrawLineStrategyType());
        drawLineStrategy.drawLine(position, board);
    }

    public LadderBoard getBoard() {
        return board;
    }

    public LineRange getRange() {
        return range;
    }

    public LineNumberFactory getNumberFactory() {
        return numberFactory;
    }

}
