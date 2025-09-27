import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderCreator {

    private final CustomLadderCreator creator;
    private final int rowCount;
    private final int colCount;
    private final Random random = new Random();

    public RandomLadderCreator(GreaterThanOne rowCount, GreaterThanOne playerCount) {
        this.creator = new CustomLadderCreator(rowCount, playerCount);
        this.rowCount = rowCount.getNumber();
        this.colCount = playerCount.getNumber();

        generateLines();
    }

    private void generateLines() {
        int totalLines = (int) ((rowCount * colCount) * 0.3);
        Set<String> used = new HashSet<>();

        int created = 0;
        while (created < totalLines) {
            int r = random.nextInt(rowCount);
            int c = random.nextInt(colCount - 1);

            String key = r + "-" + c;
            if (used.contains(key)) continue;

            try {
                creator.drawLine(PlayerPosition.from(r), PlayerPosition.from(c));
                used.add(key);
                created++;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    @Override
    public LadderLine[] getRows() {
        return creator.getRows();
    }

    @Override
    public void drawLine(PlayerPosition row, PlayerPosition col) {
        creator.drawLine(row, col);
    }
}