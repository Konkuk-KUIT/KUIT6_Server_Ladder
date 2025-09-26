public enum ExceptionMessage {
//    INVALID_LADDER_POSITION("사다리 위치는 1이상 자연수입니다."),
//    INVALID_LADDER_NUMBER("사다리의 행과 열은 2 이상이어야 합니다."),
    INVALID_POSITION("Invalid coordinate"),
    INVALID_START_INDEX("Invalid start index: out of bounds."),
    INVALID_DRAW_POSITION("Cannot draw: row already has a horizontal line.");
//    INVALID_NATURAL_NUMBER("자연수가 아닙니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
