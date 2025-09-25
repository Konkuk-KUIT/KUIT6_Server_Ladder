package creator;

import domain.LadderBoard;
import drawLineStrategy.DrawLineStrategy;
import drawLineStrategy.DrawLineStrategyFactory;
import drawLineStrategy.DrawLineStrategyType;
import game.LineNumber;
import game.LineNumberFactory;
import game.LineRange;
import util.NaturalNumber;

public class RandomLadderCreator implements LadderCreator{

    private final LadderBoard board;
    private final LineRange range;
    private final LineNumberFactory numberFactory;

    public RandomLadderCreator(NaturalNumber row, NaturalNumber numberOfPerson) {
        range = LineRange.getInstance(numberOfPerson);
        numberFactory = LineNumberFactory.getInstance(range);
        board = new LadderBoard(row, numberOfPerson);
        drawLine(numberFactory.factory(0));
    }

    public void drawLine(LineNumber position) {
        DrawLineStrategy drawLineStrategy = DrawLineStrategyFactory.getInstance(DrawLineStrategyType.RANDOM);
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
