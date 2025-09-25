import java.util.Random;

public class DrawNormalLineStrategy implements DrawLineStrategy{
    // 왼쪽이나 중간에 있는 경우
    @Override
    public void drawLine(LineNumber position, LadderBoard ladderBoard) {
        int startPosition = position.getNumber();

        Random random = new Random();
        for (Row row : ladderBoard.getRows()) {
            if(random.nextBoolean()) {
                row.createRightBridge(startPosition);
            }
        }
    }
}
