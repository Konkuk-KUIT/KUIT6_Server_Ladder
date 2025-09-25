import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    private static final double LINE_DENSITY = 0.3;

    @Override
    public Ladder createLadder(NaturalNumber height, NaturalNumber numberOfPeople) {
        Ladder ladder = new Ladder(height, numberOfPeople);
        int numberOfRows = height.getNumber();
        int numberOfCols = numberOfPeople.getNumber() - 1;
        if (numberOfCols < 1) {
            return ladder; // 참가자가 한 명인 경우 가로선을 긋지 않고 바로 리턴
        }

        // 구현사항 1 : 자동 생성되는 사다리의 Line의 수는 (사다리 행 * 열) * 0.3 이다.
        int numberOfLines = (int) (numberOfRows * numberOfCols * LINE_DENSITY);
        Random random = new Random();
        int linesDrawn = 0;

        while (linesDrawn < numberOfLines) {
            try {
                NaturalNumber randomRow = NaturalNumber.from(random.nextInt(numberOfRows) + 1);
                NaturalNumber randomCol = NaturalNumber.from(random.nextInt(numberOfCols) + 1);
                ladder.drawLine(randomRow, randomCol);
                linesDrawn++;
            } catch (IllegalArgumentException e) {
                // try 구문에서 예외가 발생해도 처리하지 않고 그대로 진행하여 다른 곳에 세로줄을 그릴 수 있도록 한다.
            }
        }
        return ladder;
    }
}
