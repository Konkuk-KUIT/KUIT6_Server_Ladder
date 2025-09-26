public class LadderRunner {
    private final Row[] rows;
    private LadderPrinter ladderPrinter;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
        this.ladderPrinter = new LadderPrinter(rows);
    }

    // 내려가는 실행을 전담
    // 규칙 -> 이미 다 객체지향적으로 정의되어 있음
    public int run(Position position){
        for (int i=0; i<rows.length ;i++) {
            System.out.println("Before");
            rowsPositionPrinter(Position.from(i), position);
            rows[i].nextPosition(position);
            System.out.println("After");
            rowsPositionPrinter(Position.from(i), position);
        }
        return position.getValue();
    }


    public void rowsPositionPrinter(Position row, Position position){
        ladderPrinter.LadderPrint(row, position);
    }
}
