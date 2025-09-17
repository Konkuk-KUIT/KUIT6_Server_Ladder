package exception;

public class IllegalSequenceException extends RuntimeException {
    public IllegalSequenceException() {
        super("유효하지 않은 사다리 번호 입력으로 라인을 그릴 수 없습니다.");
    }
}
