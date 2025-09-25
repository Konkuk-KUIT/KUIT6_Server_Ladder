public class Ladder {

//    private final int[][] rows;
    private final LadderBoard board;
    private final LineRange range;
    private final LineNumberFactory numberFactory;

    //row : 사다리의 높이
    //numberOfPerson : 게임에 참여하는 사람의 수
    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        range = LineRange.getInstance(numberOfPerson);
        numberFactory = LineNumberFactory.getInstance(range);
//        rows = new int[row.getNumber()][numberOfPerson.getNumber()];
        board = new LadderBoard(row, numberOfPerson);
    }

    public void drawLine(LineNumber position) {
        DrawLineStrategy drawLineStrategy = DrawLineStrategyFactory.getInstance(position.getDrawLineStrategyType());
        drawLineStrategy.drawLine(position, board);

    }

    public void run(LineNumber position) {
        board.run(position);
    }

    public LineNumberFactory getNumberFactory() {
        return numberFactory;
    }

    // test 전용
    public LadderBoard getBoard() {
        return board;
    }
}
