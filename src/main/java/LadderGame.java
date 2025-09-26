/**
 * 사다리 게임의 전체 흐름을 조율(orchestrate)하는 메인 클래스입니다.
 */
public class LadderGame {

    private final Ladder ladder;
    private final LadderRunner ladderRunner;
    private final LadderPresenter ladderPresenter;

    // 생성자는 Ladder 객체만 받습니다. 나머지 의존성은 내부에서 생성합니다.
    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
        // 기존 LadderRunner를 그대로 활용합니다.
        this.ladderRunner = new LadderRunner(ladder);
        this.ladderPresenter = new LadderPresenter();
    }

    /**
     * 특정 시작 위치에서 게임을 실행하고 전체 과정을 출력합니다.
     * @param startPosition 시작 위치 (1-based)
     */
    public void runAndPrint(int startPosition) {
        System.out.printf("--- %d번 참가자 사다리 타기 시작! ---\n", startPosition);

        // LadderRunner의 실행 로직을 가져와 출력 기능과 결합합니다.
        int currentPosition = startPosition - 1; // 0-based index
        for (int level = 0; level < ladder.getHeight(); level++) {
            // 1. 이동 전 상태 출력
            ladderPresenter.printState(ladder, level, currentPosition, "Before (Level " + (level + 1) + ")");

            // 2. LadderRunner의 핵심 이동 로직을 호출하여 다음 위치 계산
            //    (이를 위해 moveAtLevel의 접근 제어자를 public으로 변경해야 합니다.)
            currentPosition = ladderRunner.moveAtLevel(currentPosition, level);

            // 3. 이동 후 상태 출력
            ladderPresenter.printState(ladder, level, currentPosition, "After (Level " + (level + 1) + ")");
        }

        int finalPosition = currentPosition + 1;
        System.out.printf("\n--- %d번 참가자, %d번으로 도착! ---\n", startPosition, finalPosition);
    }
}