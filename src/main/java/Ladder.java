import java.util.Arrays;
import java.util.Objects;

public class Ladder {
    private final Row[] rows;
    private final int numberOfPerson;

//    Ladder(Row[] rows, int numberOfPerson) {
//        this.rows = rows;
//        this.numberOfPerson = numberOfPerson;
//    }

    Ladder(Row[] rows, int numberOfPerson) {
        Objects.requireNonNull(rows, "rows");
        this.numberOfPerson = numberOfPerson;
        Row[] copy = new Row[rows.length];
        for (int i = 0; i < rows.length; i++) {
            Row row = Objects.requireNonNull(rows[i], "rows[" + i + "] is null");
            if (row.width() != numberOfPerson) {
                throw new IllegalArgumentException("Row width mismatch at index " + i + ": " + row.width() + " != " + numberOfPerson);
            }
            copy[i] = row.snapshot(); // 내부 불변 상태 보장
        }
        this.rows = copy;
    }


    public int getHeight() {
        return rows.length;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }


    public Row[] getRows() {
        return Arrays.copyOf(rows, rows.length);
    }
}