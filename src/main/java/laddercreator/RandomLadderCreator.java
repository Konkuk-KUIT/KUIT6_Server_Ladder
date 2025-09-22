package laddercreator;

import board.Board;
import board.LadderBoard;
import board.LineDirection;
import board.Row;
import position.Coordinate;
import position.Position;
import wrap.PersonCount;
import wrap.LadderHeight;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements Board {
    
    private final LadderBoard ladderBoard;
    private final Random random;
    
    public RandomLadderCreator(PersonCount personCount, LadderHeight ladderHeight) {
        this.ladderBoard = new LadderBoard(personCount, ladderHeight);
        this.random = new Random();
        generateRandomLines(personCount, ladderHeight);
    }
    
    private void generateRandomLines(PersonCount personCount, LadderHeight ladderHeight) {
        int totalPossibleLines = ladderHeight.getValue() * personCount.getMaxLineIndex();
        int linesToGenerate = (int) (totalPossibleLines * 0.3);
        
        Set<Coordinate> usedCoordinates = new HashSet<>();
        int attempts = 0;
        int maxAttempts = linesToGenerate * 10;
        
        while (usedCoordinates.size() < linesToGenerate && attempts < maxAttempts) {
            int y = random.nextInt(ladderHeight.getValue());
            int x = random.nextInt(personCount.getMaxLineIndex());
            
            Coordinate coordinate = Position.at(y, x);
            
            if (!usedCoordinates.contains(coordinate) && !hasAdjacentLine(coordinate, usedCoordinates)) {
                ladderBoard.drawLine(coordinate);
                usedCoordinates.add(coordinate);
            }
            attempts++;
        }
    }
    
    private boolean hasAdjacentLine(Coordinate coordinate, Set<Coordinate> usedCoordinates) {
        int y = coordinate.getY();
        int x = coordinate.getX();
        
        Coordinate leftAdjacent = Position.at(y, x - 1);
        Coordinate rightAdjacent = Position.at(y, x + 1);
        
        return usedCoordinates.contains(leftAdjacent) || usedCoordinates.contains(rightAdjacent);
    }
    
    @Override
    public void drawLine(Coordinate coordinate) {
        ladderBoard.drawLine(coordinate);
    }
    
    @Override
    public boolean hasConnection(Coordinate coordinate) {
        return ladderBoard.hasConnection(coordinate);
    }
    
    @Override
    public LineDirection getLineDirection(Coordinate coordinate) {
        return ladderBoard.getLineDirection(coordinate);
    }
    
    @Override
    public int getHeight() {
        return ladderBoard.getHeight();
    }
    
    @Override
    public int getNumberOfPerson() {
        return ladderBoard.getNumberOfPerson();
    }
    
    public Row[] getRows() {
        return ladderBoard.getRows();
    }
}
