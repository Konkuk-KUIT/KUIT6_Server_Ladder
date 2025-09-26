public class LadderRunner {
    private Row[] rows;
    private Ladder ladder; //추가->ladder 객체 만들어 상태를 바꿔줌
    private Position presPosition; //현재 플레이어의 좌표

    public LadderRunner(Row[] rows) {
        this.rows = rows;
        this.ladder = new Ladder(rows); //추가
    }

    public int run(int startColNumber) {
        this.presPosition = new Position(0, startColNumber);
        //0<=startColNum<=rows.rowSize-1
        if (startColNumber < 0 || startColNumber > rows[0].rowSize - 1)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_START_INDEX.getMessage());

        for (Row row : rows) {
            ladder.showLadder("Before", presPosition); //추가
            startColNumber = row.moveCoord(startColNumber);
            presPosition.setCol(startColNumber);
            ladder.showLadder("After", presPosition); //추가
            presPosition.setRow(presPosition.getRow()+1);
        }
        return startColNumber;
    }
}
