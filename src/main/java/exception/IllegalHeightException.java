package exception;

public class IllegalHeightException extends RuntimeException {
    public IllegalHeightException() {
        super("유효하지 않은 사다리 높이입니다.");
    }
}
