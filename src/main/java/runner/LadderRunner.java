package runner;

import exceptions.InvalidBoardNullException;
import exceptions.InvalidStartPositionException;
import exceptions.ErrorMessage;
import ladderboard.board.Board;
import position.Position;

public class LadderRunner implements GameRunner {

    // todo: startPosition -> wrapper class로 포장하는 작업이 필요할듯
    public int run(Board board, int startPosition) {
        validateGameExecution(board, startPosition);
        
        int currentPosition = startPosition;
        
        for (int y = 0; y < board.getHeight(); y++) {
            Position currentCoord = new Position(y, currentPosition);
            Position leftCoord = new Position(y, currentPosition - 1);
            
            if (board.hasConnection(currentCoord)) {
                currentPosition++;
            } else if (currentPosition > 0 && board.hasConnection(leftCoord)) {
                currentPosition--;
            }
        }
        
        return currentPosition;
    }
    
    private void validateGameExecution(Board board, int startPosition) {
        if (board == null) {
            throw new InvalidBoardNullException(ErrorMessage.NULL_BOARD.getMessage());
        }

        if (startPosition < 0) {
            throw new InvalidStartPositionException(ErrorMessage.INVALID_START_POSITION_NEGATIVE.format(startPosition));
        }
        
        if (startPosition >= board.getNumberOfPerson()) {
            throw new InvalidStartPositionException(ErrorMessage.INVALID_START_POSITION_EXCEED.format(startPosition, board.getNumberOfPerson()));
        }
    }
}