package runner;

import exceptions.InvalidBoardNullException;
import exceptions.InvalidStartPositionException;
import exceptions.ErrorMessage;
import board.Board;
import observer.Observer;
import position.Position;
import wrap.StartPosition;

import java.util.ArrayList;
import java.util.List;

public class LadderRunner implements GameRunner {

    private final List<Observer> observers = new ArrayList<>();
    
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public Position run(Board board, StartPosition startPosition) {
        validateGameExecution(board, startPosition);
        
        notifyGameStart(board, startPosition);

        int currentPosition = startPosition.getValue();

        for (int y = 0; y < board.getHeight(); y++) {
            Position currentCoord = Position.at(y, currentPosition);
            
            // Before 상태 알림
            notifyStepStart(currentCoord);
            
            // 이동 로직 수행
            Position leftCoord = Position.at(y, currentPosition - 1);
            
            if (board.hasConnection(currentCoord)) {
                currentPosition++;
            } else if (currentPosition > 0 && board.hasConnection(leftCoord)) {
                currentPosition--;
            }
            
            // After 상태 알림
            Position newCoord = Position.at(y, currentPosition);
            notifyStepComplete(newCoord);
        }
        
        Position finalPosition = Position.at(board.getHeight(), currentPosition);
        notifyGameComplete(finalPosition);
        
        return finalPosition;
    }
    
    private void notifyGameStart(Board board, StartPosition startPosition) {
        for (Observer observer : observers) {
            observer.onGameStart(board, startPosition);
        }
    }
    
    private void notifyStepStart(Position currentPosition) {
        for (Observer observer : observers) {
            observer.onStepStart(currentPosition);
        }
    }
    
    private void notifyStepComplete(Position newPosition) {
        for (Observer observer : observers) {
            observer.onStepComplete(newPosition);
        }
    }
    
    private void notifyGameComplete(Position finalPosition) {
        for (Observer observer : observers) {
            observer.onGameComplete(finalPosition);
        }
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