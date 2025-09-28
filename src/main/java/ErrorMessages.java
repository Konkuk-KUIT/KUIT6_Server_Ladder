public enum ErrorMessages {
    INVALID_DRAW_POSITION("사다리를 그릴 수 없는 위치입니다"),
    NOT_GREATER_THAN_ONE("1보다 큰 값을 가져야합니다."),
    INVALID_POSITION("유효하지 않은 위치입니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
