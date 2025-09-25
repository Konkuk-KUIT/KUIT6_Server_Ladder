public class Row {

    private final LadderDirections[] ladderStates;

    public LadderDirections[] getLadderStates() {
        return ladderStates;
    }

    public Row(NaturalNumber numberOfPerson) {

        this.ladderStates = new LadderDirections[numberOfPerson.getNumber()];

        for (int i = 0; i < numberOfPerson.getNumber(); i++)
            ladderStates[i] = LadderDirections.CENTER;
    }

    public void drawLine(int row) {
        boolean isValidRowRange = row >= 0 && row < ladderStates.length - 1;
        // 구현사항 2 : 가로선 중복 여부 확인
        boolean canDrawLine = ladderStates[row] == LadderDirections.CENTER && ladderStates[row + 1] == LadderDirections.CENTER;

        // 행이 유효한 범위로 설정이 되었는지 확인 -> 유효하지 않은 범위인 경우 에러메시지
        if (!isValidRowRange) throw new IllegalArgumentException(ExceptionMessages.INVALID_DRAW_POSITION.getMessage());

        // 해당 위치에 사다리를 만들 수 있는지 확인
        // -> 상태값이 CENTER가 아니면 이미 사다리가 만들어져있다는 뜻이므로 에러메시지
        if(!canDrawLine) throw new IllegalArgumentException(ExceptionMessages.INVALID_DRAW_POSITION.getMessage());

        // 앞선 두 검증이 끝나면 사다리 생성
        // 왼쪽에서 오른쪽으로 만들어야 오른쪽 입장에서 왼쪽으로 갈 수가 있다.
        ladderStates[row] = LadderDirections.RIGHT;
        ladderStates[row + 1] = LadderDirections.LEFT;
    }
}
