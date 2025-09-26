import java.sql.SQLOutput;

public class Ladder {

    private final Row[] rows;

    public Ladder(Row[] rows) {
        this.rows = rows;
    }

    //ladder 출력 class
    public void showLadder(String message, Position pos) {
        System.out.println(message);
        for (int i = 0; i < rows.length; i++) {
            orderShowRow(i, pos.getRow(), pos.getCol());
            System.out.println();
        }
        System.out.println();
    }

    public void showTotalLadder() {
        for (Row row : rows) {
            row.showTotalRow();
            System.out.println();
        }
    }

    public void orderShowRow(int i, int posRow, int posCol){
        if (i == posRow) {
            rows[i].showRow(posCol);
            return;
        }
        //todo: magic num 없애기
        rows[i].showRow(-1);
    }
}