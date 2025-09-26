/**
 * 사다리 게임의 상태를 콘솔에 출력하는 역할을 담당합니다.
 */
public class LadderPresenter {

    private static final String RUNG = "-----";
    private static final String NO_RUNG = "     ";
    private static final String VERTICAL_BAR = "|";
    private static final String POSITION_MARKER = "*";

    /**
     * 사다리의 전체 모습과 특정 높이에서의 참가자 위치를 출력합니다.
     * @param ladder 출력할 사다리 객체
     * @param currentLevel 참가자가 위치한 현재 높이 (0-based)
     * @param currentPosition 참가자의 현재 위치 (0-based)
     * @param title "Before", "After" 와 같은 상태 제목
     */
    public void printState(Ladder ladder, int currentLevel, int currentPosition, String title) {
        System.out.println("\n" + title);
        for (int h = 0; h < ladder.getHeight(); h++) {
            // 사다리 가로선 라인을 먼저 출력합니다.
            StringBuilder rowBuilder = new StringBuilder("  "); // 이름 표기를 위한 간격
            for (int p = 0; p < ladder.getParticipantCount() - 1; p++) {
                rowBuilder.append(VERTICAL_BAR);
                rowBuilder.append(ladder.hasRungAt(h, p) ? RUNG : NO_RUNG);
            }
            rowBuilder.append(VERTICAL_BAR);
            System.out.println(rowBuilder);

            // 현재 레벨에 해당하면 참가자 위치(*)를 출력합니다.
            if (h == currentLevel) {
                printParticipantPosition(ladder.getParticipantCount(), currentPosition);
            }
        }
    }

    private void printParticipantPosition(int participantCount, int position) {
        StringBuilder posBuilder = new StringBuilder();
        for (int i = 0; i < participantCount; i++) {
            // 각 참가자 이름 위치에 맞춰 공백 계산
            posBuilder.append(String.format("%-6s", i == position ? (i+1) + POSITION_MARKER : ""));
        }
        System.out.println(posBuilder);
    }
}