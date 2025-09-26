import java.util.HashSet;
import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    private final Row[] rows;
    private final int numberOfRow;
    private final int numberOfPerson;

    public RandomLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfRow = numberOfRow.getNumber();
        this.numberOfPerson = numberOfPerson.getNumber();
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        autoCreateLines();
    }

    private void autoCreateLines() {
        int totalLines = (int)(numberOfRow * numberOfPerson * 0.3);
        Random rand = new Random();
        HashSet<String> created = new HashSet<>();

        while (created.size() < totalLines) {
            int r = rand.nextInt(numberOfRow);
            int c = rand.nextInt(numberOfPerson - 1); // 오른쪽 한칸 공간 필요
            String key = r + "-" + c;

            try {
                rows[r].drawLine(c); // 유효성은 Row의 drawLine에서 체크됨
                created.add(key);
            } catch (IllegalArgumentException e) {
                // 겹침 등 유효성 불가일 때 반복
            }
        }
    }

    @Override
    public void drawline(int row, int col) {
        rows[row].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
