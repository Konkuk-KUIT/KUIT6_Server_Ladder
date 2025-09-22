package observer;

import board.LineDirection;
import board.Board;
import position.Position;
import wrap.StartPosition;

import java.util.Scanner;

public class LadderPrinter implements LadderGameObserver {
    
    private Board board;
    private final Scanner scanner;
    
    public LadderPrinter() {
        this.scanner = new Scanner(System.in);
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
        waitForUserInput();
    }
    
    @Override
    public void onStepComplete(Position newPosition) {
        System.out.println("After");
        printLadderWithPlayer(newPosition);
        waitForUserInput();
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
                
                // 가로선 정보 출력 (1, -1, 0)
                System.out.print(direction.getValue());
                
                // 현재 플레이어 위치에 * 표시
                if (row == playerPosition.getY() && col == playerPosition.getX()) {
                    System.out.print("*");
                }
                
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private void waitForUserInput() {
        // 자동 진행 - 사용자 입력 대기 없음
        System.out.println();
    }
}