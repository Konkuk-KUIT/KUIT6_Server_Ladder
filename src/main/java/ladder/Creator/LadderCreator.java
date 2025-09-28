package ladder.Creator;

import ladder.unit.LadderPosition;
import ladder.unit.Row;

public interface LadderCreator {
    Row[] getRows();
    default void drawLine(){
        throw new UnsupportedOperationException("Not implemented");

    };
    default void drawLine(LadderPosition ladderPosition){
        throw new UnsupportedOperationException("Not implemented");
    };
}
