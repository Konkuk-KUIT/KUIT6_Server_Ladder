public enum ErrorMessage {
    INVALID_DUPLICATE("중복해서 사다리를 이을 수 없습니다."),
    INVALID_BOUNDARY("사다리의 경계는 이을 수 없습니다."),
    INVALID_START_RANGE("경계를 넘어서서 접근이 불가합니다."),
    INVALID_LADDER_LENGTH("사다리는 1개씩 그릴 수 있으며 동일한 지점을 이을 수 없습니다."),
    INVALID_LADDER_LEVEL("높이가 다른 지점은 이을 수 없습니다."),
    INVALID_GREATER_THAN_ONE("숫자는 1보다 커야 합니다.");

    private final String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
