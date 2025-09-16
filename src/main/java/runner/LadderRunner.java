package runner;

import exceptions.InvalidStartPositionException;
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
            throw new IllegalArgumentException("보드는 null일 수 없습니다");
        }

        if (startPosition < 0) {
            throw new InvalidStartPositionException("시작 위치가 음수일 수 없습니다: " + startPosition + " < 0");
        }
        
        if (startPosition >= board.getNumberOfPerson()) {
            throw new InvalidStartPositionException("시작 위치가 사람 수를 초과합니다: " + startPosition + " >= " + board.getNumberOfPerson());
        }
    }
}