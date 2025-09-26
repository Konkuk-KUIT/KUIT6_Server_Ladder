package printer;

import domain.Ladder;
import domain.Position;
import domain.Row;

public class LadderPrinter {

    private final Ladder ladder;

    public LadderPrinter(Ladder ladder) {
        this.ladder = ladder;
    }

    public void printLadder() {
        for (Row row : ladder.getRowObjects()) {
            printRow(row, -1); // -1 -> 현재 위치 없음
        }
    }

    public void printMovement(Position start) {
        Position current = start;

        for (Row row : ladder.getRowObjects()) {
            System.out.println("Before");
            printRow(row, current.value());

            // 이동
            Position moved = row.move(current);

            System.out.println("After");
            printRow(row, moved.value());

            current = moved; // 다음 줄 이동
        }
    }

    private void printRow(Row row, int position) {
        int[] cols = row.getColumns();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {
            if (i == position) {
                sb.append(cols[i]).append("* ");
            } else {
                sb.append(cols[i]).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
