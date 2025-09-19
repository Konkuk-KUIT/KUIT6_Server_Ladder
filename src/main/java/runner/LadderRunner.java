package runner;

import exceptions.InvalidStartPositionException;
import exceptions.ErrorMessage;
import board.LadderBoard;
import position.Position;

public class LadderRunner implements GameRunner {

    // todo: startPosition -> wrapper class로 포장하는 작업이 필요할듯
    public int run(LadderBoard ladderBoard, int startPosition) {
        validateGameExecution(ladderBoard, startPosition);
        
        int currentPosition = startPosition;
        
        for (int y = 0; y < ladderBoard.getHeight(); y++) {
            Position currentCoord = new Position(y, currentPosition);
            Position leftCoord = new Position(y, currentPosition - 1);
            
            if (ladderBoard.hasConnection(currentCoord)) {
                currentPosition++;
            } else if (currentPosition > 0 && ladderBoard.hasConnection(leftCoord)) {
                currentPosition--;
            }
        }
        
        return currentPosition;
    }
    
    private void validateGameExecution(LadderBoard ladderBoard, int startPosition) {
        if (ladderBoard == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_BOARD.getMessage());
        }

        if (startPosition < 0) {
            throw new InvalidStartPositionException(ErrorMessage.INVALID_START_POSITION_NEGATIVE.format(startPosition));
        }
        
        if (startPosition >= ladderBoard.getNumberOfPerson()) {
            throw new InvalidStartPositionException(ErrorMessage.INVALID_START_POSITION_EXCEED.format(startPosition, ladderBoard.getNumberOfPerson()));
        }
    }
}