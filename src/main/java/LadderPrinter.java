public class LadderPrinter {
    private final Row[] rows;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public void LadderPrint(Position row, Position position) {
        for (int i=0;i<rows.length ;i++) {
            // TODO Printer 객체 선언
            if(i==row.getValue()){
                rows[i].printRow(position);
            }
            else{
                rows[i].printRow();
            }
        }
    }
}
