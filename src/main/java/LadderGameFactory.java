/**
 * LadderGame 객체의 생성을 책임지는 팩토리 클래스입니다.
 * 의존성 주입(DI)을 처리하여 LadderGame 생성을 단순화합니다.
 */
public class LadderGameFactory {

    /**
     * 참가자 수와 높이를 받아 무작위로 생성된 사다리를 포함하는 LadderGame 객체를 생성합니다.
     * @param participantCount 게임 참가자 수
     * @param height 사다리 높이
     * @return 설정이 완료된 LadderGame 객체
     */
    public static LadderGame createRandomLadderGame(int participantCount, int height) {
        Ladder ladder = new Ladder(participantCount, height);
        RungGenerator generator = new RandomRungGenerator();

        // 생성 전략에 따라 사다리 가로선 생성
        generator.generate(ladder);

        return new LadderGame(ladder);
    }
}