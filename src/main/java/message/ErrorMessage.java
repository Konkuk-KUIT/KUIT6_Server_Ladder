package message;

public enum ErrorMessage {
    SEQUENCE("유효하지 않은 사다리 번호 입력으로 라인을 그릴 수 없습니다."),
    HEIGHT("유효하지 않은 사다리 높이입니다."),
    LADDER_NUM("존재하지 않는 사다리 번호입니다."),
    LINER("유효하지 않은 입력으로 인하여 사다리 생성에 실패하였습니다.");

    private final String message;

    public String getMessage() {
        return message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}
