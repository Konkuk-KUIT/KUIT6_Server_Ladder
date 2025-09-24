public enum ErrorMessage {
    INVALID_SELECTED_INDEX("선택 인덱스는 1 이상이어야 합니다."),
    OUT_OF_HEIGHT("사다리 높이를 초과했습니다."),
    SAME_COLUMN("같은 세로줄에는 선을 그을 수 없습니다."),
    IndexOutOfBound("선택 인덱스는 사이에 있어야 합니다."),
    OUT_OF_NATURE_NUMBER("음수를 입력하셨습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}