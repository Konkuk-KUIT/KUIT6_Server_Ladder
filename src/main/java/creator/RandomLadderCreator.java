package creator;

import domain.LadderSize;
import domain.Row;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderCreator {
    private final CustomLadderCreator delegate; // 조합으로 재사용
    private final Random random = new Random();

    public RandomLadderCreator(LadderSize size) {
        this.delegate = new CustomLadderCreator(size);
        autoGenerateLines(size);
    }

    private void autoGenerateLines(LadderSize size) {
        int targetLines = size.calculateLineCount();
        Set<String> used = new HashSet<>();
        int created = 0;

        while (created < targetLines) {
            int rowIndex = random.nextInt(size.numberOfRow());
            int personIndex = random.nextInt(size.numberOfPerson() - 1);

            String key = rowIndex + "-" + personIndex;
            if (used.contains(key)) continue;

            try {
                delegate.drawLine(rowIndex, personIndex);
                used.add(key);
                created++;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    @Override
    public void drawLine(int row, int person) {
        delegate.drawLine(row, person);
    }

    @Override
    public Row[] getRows() {
        return delegate.getRows();
    }
}
