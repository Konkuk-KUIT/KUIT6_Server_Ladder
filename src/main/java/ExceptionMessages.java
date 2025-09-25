public enum ExceptionMessages {
    INVALID_LADDER_POSITION("사다리 위치는 1이상 자연수입니다."),
    INVALID_LADDER_NUMBER("사다리의 행과 열은 2 이상이어야 합니다."),
    INVALID_POSITION("유효하지 않은 위치입니다."),
    INVALID_DRAW_POSITION("사다리를 그릴 수 없는 위치입니다."),
    INVALID_NATURAL_NUMBER("자연수가 아닙니다."),
    INVALID_LADDER_NULL("사다리 값이 없을 수 없습니다."),
    INVALID_RANGE_OF_LADDER("결과값은 1과 참여 인원 수 사이에 있어야 합니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
