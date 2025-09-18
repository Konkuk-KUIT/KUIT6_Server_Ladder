public class Ladder {

//    private final int[][] rows;
    LadderBoard board;
    LineRange range;
    LineNumberFactory numberFactory;

    //row : 사다리의 높이
    //numberOfPerson : 게임에 참여하는 사람의 수
    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        range = new LineRange(numberOfPerson);
        numberFactory = new LineNumberFactory(range);
//        rows = new int[row.getNumber()][numberOfPerson.getNumber()];
        board = new LadderBoard(row, numberOfPerson);
    }

    public void drawLine(LineNumber position) {
        DrawLineStrategy drawLineStrategy = DrawLineStrategyFactory.getInstance(position.getDrawLineStrategyType());
        drawLineStrategy.drawLine(position, board);
    }

    public void run(LineNumber position) {
        int nowColumn = position.getNumber();

        for(int i=0; i< board.rows(); i++) {
            nowColumn = board.checkBoard(i, nowColumn);
        }

        System.out.println(nowColumn);
    }

    public LineNumberFactory getNumberFactory() {
        return numberFactory;
    }

    // test 전용
    public LadderBoard getBoard() {
        return board;
    }
}
