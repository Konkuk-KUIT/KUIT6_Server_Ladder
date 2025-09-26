/**
 * 주어진 Ladder 객체를 기반으로 사다리 타기 게임을 실행하는 역할을 합니다.
 * 이 클래스는 '어떻게 움직이는지'에 대한 로직을 책임집니다.
 */
public class LadderRunner {

    private final Ladder ladder;

    public LadderRunner(Ladder ladder) {
        this.ladder = ladder;
    }

    /**
     * 특정 번호의 사다리를 타고 내려갔을 때의 결과 번호를 반환합니다.
     * @param startPosition 시작하는 사다리 번호 (1부터 시작)
     * @return 도착하는 사다리 번호
     */
    public int run(int startPosition) {
        int currentPosition = startPosition - 1; // 0-based index로 변환
        for (int level = 0; level < ladder.getHeight(); level++) {
            currentPosition = moveAtLevel(currentPosition, level);
        }
        return currentPosition + 1; // 1-based index로 변환하여 반환
    }

    /**
     * 특정 높이(level)에서 현재 위치(position)의 이동을 결정합니다.
     * @param position 현재 위치 (0-based)
     * @param level 현재 높이 (0-based)
     * @return 이동 후의 위치 (0-based)
     */
    public int moveAtLevel(int position, int level) {
        if (hasRungToTheLeft(position, level)) {
            return position - 1; // 왼쪽으로 이동
        }
        if (hasRungToTheRight(position, level)) {
            return position + 1; // 오른쪽으로 이동
        }
        return position; // 이동 없음
    }

    private boolean hasRungToTheLeft(int position, int level) {
        // 왼쪽에 가로선이 있으려면, 현재 위치가 0보다 크고, `현재 위치 - 1`에 가로선이 있어야 함
        return position > 0 && ladder.hasRungAt(level, position - 1);
    }

    private boolean hasRungToTheRight(int position, int level) {
        // 오른쪽에 가로선이 있으려면, 현재 위치가 `전체 참가자 수 - 1`보다 작고, `현재 위치`에 가로선이 있어야 함
        return position < ladder.getParticipantCount() - 1 && ladder.hasRungAt(level, position);
    }
}