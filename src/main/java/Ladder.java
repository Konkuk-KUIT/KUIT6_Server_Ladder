// Ladder.java
public class Ladder {

    private final int participantCount;
    private final int height;
    private final boolean[][] rungs;

    /**
     * 참가자 수와 사다리 높이를 기반으로 비어있는 사다리를 생성합니다.
     * @param participantCount 게임 참가자 수 (세로줄의 개수)
     * @param height 사다리의 높이
     */
    public Ladder(int participantCount, int height) {
        if (participantCount < 2 || height < 1) {
            throw new IllegalArgumentException("참가자는 2명 이상, 높이는 1 이상이어야 합니다.");
        }
        this.participantCount = participantCount;
        this.height = height;
        // 가로줄은 참가자 수 - 1 만큼의 공간을 가집니다.
        this.rungs = new boolean[height][participantCount - 1];
    }

    /**
     * 지정된 위치와 높이에 가로줄을 그립니다.
     * 사용자의 입력은 1부터 시작하는 것을 기준으로 합니다.
     * @param position 가로줄을 놓을 위치 (e.g., 1은 1번과 2번 세로줄 사이)
     * @param height 가로줄을 놓을 높이
     */
    public void drawLine(int position, int height) {
        int h_idx = height - 1;
        int p_idx = position - 1;

        validateLinePosition(p_idx, h_idx);
        this.rungs[h_idx][p_idx] = true;
    }

    /**
     * 특정 번호의 사다리를 타고 내려갔을 때의 결과 번호를 반환합니다.
     * @param startPosition 시작하는 사다리 번호 (1부터 시작)
     * @return 도착하는 사다리 번호
     */
    public int run(int startPosition) {
        int currentPosition = startPosition - 1; // 0-based index로 변환
        for (int level = 0; level < this.height; level++) {
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
    private int moveAtLevel(int position, int level) {
        if (hasRungToTheLeft(position, level)) {
            return position - 1; // 왼쪽으로 이동
        }
        if (hasRungToTheRight(position, level)) {
            return position + 1; // 오른쪽으로 이동
        }
        return position; // 이동 없음
    }

    private boolean hasRungToTheLeft(int position, int level) {
        return position > 0 && rungs[level][position - 1];
    }

    private boolean hasRungToTheRight(int position, int level) {
        return position < participantCount - 1 && rungs[level][position];
    }

    private void validateLinePosition(int p_idx, int h_idx) {
        if (h_idx < 0 || h_idx >= this.height || p_idx < 0 || p_idx >= this.participantCount - 1) {
            throw new IllegalArgumentException("사다리 범위를 벗어난 위치입니다.");
        }
        // 왼쪽 인접 가로줄 확인
        if (p_idx > 0 && rungs[h_idx][p_idx - 1]) {
            throw new IllegalStateException("가로줄을 연속해서 놓을 수 없습니다.");
        }
    }
}