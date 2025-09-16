package runner;

import exceptions.InvalidStartPositionException;
import exceptions.ErrorMessage;
import board.Board;
import position.Position;

public class LadderRunner implements GameRunner {
    
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
            throw new IllegalArgumentException(ErrorMessage.NULL_BOARD.getMessage());
        }

        if (startPosition < 0) {
            throw new InvalidStartPositionException(ErrorMessage.INVALID_START_POSITION_NEGATIVE.format(startPosition));
        }
        
        if (startPosition >= board.getNumberOfPerson()) {
            throw new InvalidStartPositionException(ErrorMessage.INVALID_START_POSITION_EXCEED.format(startPosition, board.getNumberOfPerson()));
        }
    }
}