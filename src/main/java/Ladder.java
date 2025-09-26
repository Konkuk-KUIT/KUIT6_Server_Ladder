/**
 * 사다리의 구조(참가자 수, 높이, 가로선 위치)를 표현하는 순수한 데이터 객체입니다.
 * 유효성 검증은 LadderValidator에게 위임합니다.
 */
public class Ladder {

    private final int participantCount;
    private final int height;
    private final boolean[][] rungs;

    public Ladder(int participantCount, int height) {
        // 생성자 파라미터 검증을 Validator에게 위임
        LadderValidator.validateCreation(participantCount, height);
        this.participantCount = participantCount;
        this.height = height;
        this.rungs = new boolean[height][participantCount - 1];
    }

    public void drawLine(int position, int height) {
        int h_idx = height - 1;
        int p_idx = position - 1;

        // 가로선 위치 검증을 Validator에게 위임
        LadderValidator.validateLinePosition(this, p_idx, h_idx);
        this.rungs[h_idx][p_idx] = true;
    }

    // Getter 메서드들은 변경 없이 그대로 유지됩니다.
    public int getParticipantCount() {
        return participantCount;
    }

    public int getHeight() {
        return height;
    }

    public boolean hasRungAt(int level, int position) {
        // 범위를 벗어나는지 여기서 한번 더 체크해주는 것이 안전할 수 있습니다.
        if (level < 0 || level >= this.height || position < 0 || position >= this.participantCount -1) {
            return false;
        }
        return rungs[level][position];
    }
}