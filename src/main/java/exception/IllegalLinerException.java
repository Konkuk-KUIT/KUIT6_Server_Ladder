package exception;

public class IllegalLinerException extends RuntimeException {
    public IllegalLinerException() {
        super("유효하지 않은 입력으로 인하여 사다리 생성에 실패하였습니다.");
    }
}
