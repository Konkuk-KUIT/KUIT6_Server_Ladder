public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public Row[] getRows(){
        return ladderCreator.getRows();
    }

    public void drawLine(Position position) {
        ladderCreator.drawLine(position);
    }

    public int run(int startColNumber) {
        // 1. 사다리 오기
//        Row[] rows = ladderCreator.create(position.getRow(), position.getCol());
        Row[] rows = ladderCreator.getRows();

        // 2. runner 에게 사다리 전달
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());

        //3. runner를 통해 게임 진행
        return ladderRunner.run(startColNumber);
    }
}
