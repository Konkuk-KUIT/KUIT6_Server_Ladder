package ladder.creator;
import ladder.position.Position;
import ladder.core.Row;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public final class RandomLadderCreator implements LadderCreatorPort {

    private final LadderCreator delegate; // 조합
    private final LadderSize size;
    private Random random;

    public RandomLadderCreator(LadderSize size, Long seed) {
        this.size = size;
        this.random = (seed == null) ? new Random() : new Random(seed);
        this.delegate = new LadderCreator(size.rowsAsGTO(), size.colsAsGTO());
        autoGenerate();
    }



    private void autoGenerate() {
        if (size.cols() < 2) return;

        int target = size.targetLines();
        Set<Integer> picked = new HashSet<>();
        int safety = size.rows() * size.cols() * 10;

        int created = 0, tries = 0;
        while (created < target && tries++ < safety) {
            int r = random.nextInt(size.rows());
            int c = random.nextInt(size.cols() - 1); // c와 c+1을 잇는다
            int key = r * size.cols() + c;       // 같은 지점 중복 방지

            if (!picked.add(key)) continue;

            try {
                delegate.drawLine(Position.from(r), Position.from(c));
                created++;
            } catch (IllegalArgumentException ignore) {
                // Row.drawLine에서 인접/겹침/끝자리 등 유효성 검사를 하므로
                // 실패하면 그냥 패스하고 다음 좌표를 뽑는다.
            }
        }
    }

    // 포트 위임
    @Override public Row[] getRows() { return delegate.getRows(); }
    @Override public void drawLine(Position row, Position col) { delegate.drawLine(row, col); }
    @Override public int getNumberOfPerson() { return size.cols(); }
}

