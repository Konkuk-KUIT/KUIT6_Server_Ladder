public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }


    //예외처리+이동
    public NaturalNumber play(NaturalNumber start) {
        if (start.value() < 1 || start.value() > ladder.getNumberOfPersons().value()) {
            throw new IllegalArgumentException("시작 위치가 범위를 벗어났습니다: " + start);
        }

        //position 메소드 사용해서 이동
        Position current = new Position(start, ladder.getNumberOfPersons());

        for (int[] row : ladder.getRows()) {
            int c = current.value();
            int size = row.length;

            if (row[c] == 1) {
                current = current.moveRight(new NaturalNumber(size));
            }
            if (row[c] == -1) {
                current = current.moveLeft(new NaturalNumber(size));
            }

        }

        return new NaturalNumber(current.value() + 1);
    }
}
