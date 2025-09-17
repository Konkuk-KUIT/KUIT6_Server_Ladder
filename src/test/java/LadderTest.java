import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {



    @Test
    public void 줄만들기() {
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(5));
        LineNumberFactory numberFactory = ladder.getNumberFactory();
        ladder.drawLine(numberFactory.Factory(0));
        ladder.drawLine(numberFactory.Factory(1));
        ladder.drawLine(numberFactory.Factory(2));
        ladder.drawLine(numberFactory.Factory(3));
        ladder.drawLine(numberFactory.Factory(4));

        ladder.getBoard().printGrid();
    }

    @Test
    public void 줄만들고_출력하기() {
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(5));
        LineNumberFactory numberFactory = ladder.getNumberFactory();
        ladder.drawLine(numberFactory.Factory(2));
        ladder.getBoard().printGrid();
        System.out.println();
        ladder.drawLine(numberFactory.Factory(1));
        ladder.getBoard().printGrid();
        System.out.println();
        ladder.drawLine(numberFactory.Factory(3));
        ladder.getBoard().printGrid();
        System.out.println();
        ladder.drawLine(numberFactory.Factory(4));
        ladder.drawLine(numberFactory.Factory(0));

        ladder.getBoard().printGrid();

        ladder.run(numberFactory.Factory(0));
        ladder.run(numberFactory.Factory(1));
        ladder.run(numberFactory.Factory(2));
        ladder.run(numberFactory.Factory(3));
        ladder.run(numberFactory.Factory(4));
    }
}