package drawLineStrategy;

import domain.LadderBoard;
import domain.Row;
import game.LineNumber;

import java.util.Random;

public class DrawRightLineStrategy implements DrawLineStrategy {
    @Override
    public void drawLine(LineNumber position, LadderBoard ladderBoard) {
        int startPosition = position.getNumber();

        if(startPosition == 0){
            return;
        }

        Random random = new Random();
        for (Row row : ladderBoard.getRows()) {
            if(random.nextBoolean()) {
                row.createLeftBridge(startPosition);
            }
        }
    }
}
