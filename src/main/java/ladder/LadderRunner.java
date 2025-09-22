package ladder;

import ladder.Displayer.LadderDisplayer;

public class LadderRunner {

    private final Row[] rows;

    private final LadderPosition ladderPosition = new LadderPosition(0, 0);

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {

            LadderDisplayer ladderDisplayer = new LadderDisplayer(rows);
            ladderPosition.setLadderPositon(position.getValue(), i);
            ladderDisplayer.setPosition(ladderPosition.getX(), ladderPosition.getY());
            System.out.println("Before");
            ladderDisplayer.displayRows();

            rows[i].nextPosition(position);

            ladderPosition.setLadderPositon(position.getValue(), i);
            ladderDisplayer.setPosition(ladderPosition.getX(), ladderPosition.getY());
            System.out.println("After");
            ladderDisplayer.displayRows();

        }

        return position.getValue();
    }
}
