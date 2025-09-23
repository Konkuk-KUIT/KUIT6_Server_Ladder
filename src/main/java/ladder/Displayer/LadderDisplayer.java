package ladder.Displayer;

import ladder.Direction;
import ladder.Row;

public class LadderDisplayer {

    private Row[] rows;

    private int x;

    private int y;

    public LadderDisplayer(Row[] rows) {
        this.rows = rows;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setRows(Row[] rows) {
        this.rows = rows;
    }

    public void displayRows() {
        for (int j = 0; j < rows.length; j++) {
            for (int i = 0; i < rows[j].getNodes().length; i++) {
                if (rows[j].getNodes()[i].getDirection() == Direction.NONE) {
                    if (i == 0) {
                        if (i == x && j == y) {
                            System.out.print("0* ");
                            continue;
                        }
                        System.out.print("0  ");
                    } else if (i == rows[j].getNodes().length - 1) {
                        if (i == x && j == y) {
                            System.out.print("  0*");
                            continue;
                        }
                        System.out.print("  0");
                    } else {
                        if (i == x && j == y) {
                            System.out.print("0*");
                            continue;
                        }
                        System.out.print("0");
                    }
                }
                if (rows[j].getNodes()[i].getDirection() == Direction.RIGHT) {
                    if (i == x && j == y) {
                        System.out.print("1*-");
                        continue;
                    }
                    System.out.print("1-");
                }
                if (rows[j].getNodes()[i].getDirection() == Direction.LEFT) {
                    if (i == x && j == y) {
                        System.out.print("-*1");
                        continue;
                    }
                    System.out.print("-1");
                }
            }
            System.out.println("\n");
        }
        System.out.println("==============");

    }

}
