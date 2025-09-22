// LadderValidator.java
/**
 * 사다리 생성과 관련된 유효성 검증 규칙을 담당하는 클래스입니다.
 */
public class LadderValidator {

    /**
     * 사다리 생성 시 초기 파라미터(참가자 수, 높이)를 검증합니다.
     * @param participantCount 게임 참가자 수
     * @param height 사다리의 높이
     */
    public static void validateCreation(int participantCount, int height) {
        if (participantCount < 2 || height < 1) {
            throw new IllegalArgumentException("참가자는 2명 이상, 높이는 1 이상이어야 합니다.");
        }
    }

    /**
     * 가로선을 그리는 위치가 사다리 범위 내에 있고, 유효한 규칙(연속되지 않음)을 따르는지 검증합니다.
     * @param ladder 검증의 대상이 되는 사다리 객체
     * @param p_idx 가로줄 위치 (0-based)
     * @param h_idx 가로줄 높이 (0-based)
     */
    public static void validateLinePosition(Ladder ladder, int p_idx, int h_idx) {
        // 1. 사다리 범위를 벗어나는지 확인
        if (h_idx < 0 || h_idx >= ladder.getHeight() || p_idx < 0 || p_idx >= ladder.getParticipantCount() - 1) {
            throw new IllegalArgumentException("사다리 범위를 벗어난 위치입니다.");
        }

        // 2. 왼쪽에 인접한 가로줄이 있는지 확인
        if (p_idx > 0 && ladder.hasRungAt(h_idx, p_idx - 1)) {
            throw new IllegalStateException("가로줄을 연속해서 놓을 수 없습니다.");
        }

        // 3. 오른쪽에 인접한 가로줄이 있는지 확인
        if (p_idx < ladder.getParticipantCount() - 2 && ladder.hasRungAt(h_idx, p_idx + 1)) {
            throw new IllegalStateException("가로줄을 연속해서 놓을 수 없습니다.");
        }
    }
}