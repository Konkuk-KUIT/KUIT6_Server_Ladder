package runner;

import exceptions.InvalidBoardNullException;
import exceptions.InvalidStartPositionException;
import exceptions.ErrorMessage;
import ladderboard.board.Board;
import position.Position;
import wrap.StartPosition;

public class LadderRunner implements GameRunner {

    // todo: startPosition -> wrapper class로 포장하는 작업이 필요할듯
    public Position run(Board board, StartPosition startPosition) {
        validateGameExecution(board, startPosition);

        int currentPosition = startPosition.getValue();

        for (int y = 0; y < board.getHeight(); y++) {
            Position currentCoord = Position.at(y, currentPosition);
            Position leftCoord = Position.at(y, currentPosition - 1);
            
            if (board.hasConnection(currentCoord)) {
                currentPosition++;
            } else if (currentPosition > 0 && board.hasConnection(leftCoord)) {
                currentPosition--;
            }
        }
        
        return Position.at(board.getHeight(), currentPosition);
    }
    
    private void validateGameExecution(Board board, StartPosition startPosition) {
        if (board == null) {
            throw new InvalidBoardNullException(ErrorMessage.NULL_BOARD.getMessage());
        }

        if (startPosition.getValue() < 0) {
            throw new InvalidStartPositionException(ErrorMessage.INVALID_START_POSITION_NEGATIVE.format(startPosition.getValue()));
        }
        
        if (startPosition.getValue() >= board.getNumberOfPerson()) {
            throw new InvalidStartPositionException(ErrorMessage.INVALID_START_POSITION_EXCEED.format(startPosition.getValue(), board.getNumberOfPerson()));
        }
    }
}