package exceptions;

public enum ErrorMessage {
    // PersonCount 관련
    INVALID_PERSON_COUNT("사람의 수가 0 이하인 경우 게임 진행이 불가합니다"),
    
    // LadderHeight 관련
    INVALID_LADDER_HEIGHT("사다리 높이는 0보다 커야 합니다"),
    
    // 좌표 관련
    NULL_COORDINATE("좌표는 null일 수 없습니다"),
    INVALID_COORDINATE_Y("Y 좌표가 범위를 벗어났습니다: %d (0-%d)"),
    INVALID_COORDINATE_X("X 좌표가 범위를 벗어났습니다: %d (0-%d)"),
    DUPLICATE_LINE("이미 선이 존재합니다: (%d, %d)"),
    
    // 게임 실행 관련
    NULL_BOARD("보드는 null일 수 없습니다"),
    INVALID_START_POSITION_NEGATIVE("시작 위치는 0 이상이어야 합니다: %d"),
    INVALID_START_POSITION_EXCEED("시작 위치가 사람 수를 초과합니다: %d >= %d");
    
    private final String message;
    
    ErrorMessage(String message) {
        this.message = message;
    }
    
    public String format(Object... args) {
        return String.format(message, args);
    }
    
    public String getMessage() {
        return message;
    }
}