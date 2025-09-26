package game;

import creator.LadderCreator;
import creator.RandomLadderCreator;
import domain.Ladder;
import domain.LadderSize;
import domain.Row;

public class LadderGameFactory {

    private LadderGameFactory() {
    }

    public static LadderGame createRandomLadderGame(int rowCount, int personCount) {
        LadderSize size = new LadderSize(rowCount, personCount);
        LadderCreator creator = new RandomLadderCreator(size);

        Row[] rows = creator.getRows();
        Ladder ladder = new Ladder(size, rows);

        return new LadderGame(ladder);
    }

    public static LadderGame createWithCreator(int rowCount, int personCount, LadderCreator creator) {
        LadderSize size = new LadderSize(rowCount, personCount);

        Row[] rows = creator.getRows();
        Ladder ladder = new Ladder(size, rows);

        return new LadderGame(ladder);
    }
}
