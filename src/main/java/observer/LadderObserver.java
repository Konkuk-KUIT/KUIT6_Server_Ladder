package observer;

import board.LineDirection;
import board.Board;
import position.Position;
import wrap.StartPosition;

import java.util.Scanner;

public class LadderObserver implements Observer {
    
    private Board board;

    public LadderObserver() {
    }
    
    @Override
    public void onGameStart(Board board, StartPosition startPosition) {
        this.board = board;
        System.out.println("=== Ladder Game Start ===");
        System.out.println("Starting position: " + startPosition.getValue());
        System.out.println();
    }
    
    @Override
    public void onStepStart(Position currentPosition) {
        System.out.println("Before");
        printLadderWithPlayer(currentPosition);
    }
    
    @Override
    public void onStepComplete(Position newPosition) {
        System.out.println("After");
        printLadderWithPlayer(newPosition);
    }
    
    @Override
    public void onGameComplete(Position finalPosition) {
        System.out.println("=== Game Complete ===");
        System.out.println("Final position: " + finalPosition.getX());
    }
    
    private void printLadderWithPlayer(Position playerPosition) {
        for (int row = 0; row < board.getHeight(); row++) {
            for (int col = 0; col < board.getNumberOfPerson(); col++) {
                Position currentPos = Position.at(row, col);
                LineDirection direction = board.getLineDirection(currentPos);
                
                // 가로선 정보와 플레이어 위치 표시
                String playerMarker = (row == playerPosition.getY() && col == playerPosition.getX()) ? "*" : "";
                System.out.print(direction.getValue() + playerMarker + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}