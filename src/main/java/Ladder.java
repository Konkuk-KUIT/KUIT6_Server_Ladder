import java.util.Arrays;

public class Ladder {
    private final Row[] rows;
    private final int numberOfPerson;

    Ladder(Row[] rows, int numberOfPerson) {
        this.rows = rows;
        this.numberOfPerson = numberOfPerson;
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