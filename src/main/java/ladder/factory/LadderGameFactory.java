package ladder.factory;

import ladder.LadderGame;
import ladder.LadderPosition;
import ladder.creator.LadderCreator;
import ladder.creator.NormalLadderCreator;
import ladder.creator.RandomLadderCreator;
import ladder.model.GreaterThanOne;
import ladder.model.Position;

import java.util.List;

public class LadderGameFactory {

    public static LadderGame createNormalLadder(GreaterThanOne rows, GreaterThanOne numberOfPerson, List<LadderPosition> lines) {

        NormalLadderCreator creator = new NormalLadderCreator(rows, numberOfPerson);

        //초기 라인 세팅
        for (LadderPosition line : lines) {
            creator.drawLine(Position.from(line.getRow()), Position.from(line.getCol()));
        }

        return new LadderGame(creator);
    }

    public static LadderGame createRandomLadder(GreaterThanOne rows, GreaterThanOne numberOfPerson) {

        RandomLadderCreator creator = new RandomLadderCreator(rows, numberOfPerson);
        return new LadderGame(creator);
    }
}
