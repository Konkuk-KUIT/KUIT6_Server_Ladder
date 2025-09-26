import java.util.Random;

/**
 * 무작위로 사다리 가로선을 생성하는 클래스입니다.
 * 기존의 LadderValidator를 간접적으로 활용하여 연속된 가로선 생성을 방지합니다.
 */
public class RandomRungGenerator implements RungGenerator {

    private final Random random = new Random();

    @Override
    public void generate(Ladder ladder) {
        int participantCount = ladder.getParticipantCount();
        int height = ladder.getHeight();
        // 생성할 가로선 수 = (가로선 놓을 수 있는 전체 공간) * 0.3
        int targetRungCount = (int) ((participantCount - 1) * height * 0.3);

        int createdCount = 0;
        while (createdCount < targetRungCount) {
            int h = random.nextInt(height) + 1; // 1-based height
            int p = random.nextInt(participantCount - 1) + 1; // 1-based position

            try {
                // ladder.drawLine은 내부적으로 LadderValidator.validateLinePosition를 호출합니다.
                // 만약 연속된 가로선을 놓으려 하면 IllegalStateException이 발생합니다.
                ladder.drawLine(p, h);
                createdCount++;
            } catch (IllegalStateException e) {
                // 연속된 가로선을 놓으려는 시도는 무시하고 다음 랜덤 위치를 시도합니다.
            }
        }
    }
}