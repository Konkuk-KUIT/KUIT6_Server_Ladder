package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position){
        for (Row row : rows) {
            row.nextPosition(position);
        }
        return position.getValue();
    }
}
