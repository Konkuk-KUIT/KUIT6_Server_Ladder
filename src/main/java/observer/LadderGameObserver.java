package observer;

import ladderboard.board.Board;
import position.Position;
import wrap.StartPosition;

public interface LadderGameObserver {
    
    void onGameStart(Board board, StartPosition startPosition);
    
    void onStepStart(Position currentPosition);
    
    void onStepComplete(Position newPosition);
    
    void onGameComplete(Position finalPosition);
}