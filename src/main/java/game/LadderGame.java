package game;

import domain.Ladder;
import domain.NaturalNumber;
import domain.Position;
import domain.Row;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    // 예외처리 + 이동
    public NaturalNumber play(NaturalNumber start) {
        if (start.value() < 1 || start.value() > ladder.getNumberOfPersons().value()) {
            throw new IllegalArgumentException("시작 위치가 범위를 벗어났습니다: " + start);
        }

        Position current = new Position(start, ladder.getNumberOfPersons());

        for (Row row : ladder.getRowObjects()) {
            current = row.move(current);
        }

        return new NaturalNumber(current.value() + 1);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
