package exception;

public class IllegalLadderNumberException extends RuntimeException {
    public IllegalLadderNumberException() {
        super("존재하지 않는 사다리 번호입니다.");
    }
}
