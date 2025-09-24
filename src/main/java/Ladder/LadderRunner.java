package Ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position startPosition){
        Position currentPosition = startPosition;
        for (Row row : rows){
            currentPosition = row.moveNextPosition(currentPosition);
        }
        return currentPosition;
    }
}
