package drawLineStrategy;

import domain.LadderBoard;
import game.LineNumber;

import java.util.HashSet;
import java.util.Set;

public class RandomDrawLIneStrategy implements DrawLineStrategy {

    @Override
    public void drawLine(LineNumber position, LadderBoard ladderBoard) {
        int row = ladderBoard.rows();
        int col = ladderBoard.cols();
        int count =(int)(row * col * 0.3);
        ArrayIndex arrayIndex;
        Set<ArrayIndex> picked = new HashSet<>();

        // row 가 한개인 경우
        if(col == 1){
            return;
        }

        while (picked.size() <= count ) {
            arrayIndex= ArrayIndex.RandomIndex(row, col);
            if(arrayIndex.getY() == col-1){
                continue;
            }
            if(ladderBoard.createRightBridge(arrayIndex)){
                continue;
            }
            picked.add(arrayIndex);
        }
    }

}
