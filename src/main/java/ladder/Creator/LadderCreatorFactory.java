package ladder.Creator;

import ladder.Constant.LadderState;
import ladder.Constant.LadderType;
import ladder.Domain.GreaterThanOne;

public class LadderCreatorFactory {
    private LadderCreatorFactory() {}

    public static LadderCreator getLadderCreator(LadderType type, GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        switch (type) {
            case LADDER_TYPE_AUTO -> {
                return new AutoLadderCreator(numberOfRows, numberOfPerson);
            }
            case LADDER_TYPE_MANUAL -> {
                return new ManualLadderCreator(numberOfRows, numberOfPerson);
            }
        }
        return null;
    }
}
