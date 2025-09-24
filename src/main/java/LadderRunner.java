public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position){

        for (int height=0; height<rows.length; height++) {
            LadderViewer.viewLadder(rows, height,position,false);
            rows[height].nextPosition(position);
            LadderViewer.viewLadder(rows, height,position,true);
        }
        return position.getValue();
    }
}
