public class LadderRunner {
    private final LadderLine[] rows;


    public LadderRunner(LadderLine[] rows) {
        this.rows = rows;
    }

    public int run(PlayerPosition position){
        for (LadderLine row : rows){
            row.move(position);
        }
        return position.getValue();
    }
}
