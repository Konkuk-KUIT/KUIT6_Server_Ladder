package domain;

import drawLineStrategy.ArrayIndex;
import game.LineNumber;
import game.LineRange;
import util.NaturalNumber;

public final class LadderBoard {
    private Row[] rows;
    private LineRange range;

    public LadderBoard(NaturalNumber rows, NaturalNumber cols) {
        this.rows = new Row[rows.getNumber()];
        for (int i = 0; i < rows.getNumber(); i++) {
            this.rows[i] = new Row(cols);
        }
        this.range = LineRange.getInstance(cols);
    }

    public Row[] getRows() {
        return rows;
    }

    public int rows() {
        return rows.length;
    }

    public int cols() {
        return range.getRange().getNumber();
    }
    public void run(LineNumber position){
        for(int i=0; i<rows.length; i++){
            System.out.println("Before");
            printRow(i,position);
            rows[i].run(position);
            System.out.println("After");
            printRow(i,position);
        }
        System.out.println(position);
    }

    private void printRow(int r, LineNumber position) {
        for(int i=0; i<rows.length; i++){
            if(i==r) {
                rows[i].printStar(position);
                continue;
            }
            rows[i].printRow();
        }
    }


    // test 전용
    public void printGrid() {
        for (Row row : rows) {
            row.printRow();
        }

    }


    public boolean createRightBridge(ArrayIndex arrayIndex) {
        return rows[arrayIndex.getX()].createRightBridge(arrayIndex.getY());
    }
}