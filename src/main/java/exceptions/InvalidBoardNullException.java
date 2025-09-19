package exceptions;

public class InvalidBoardNullException extends RuntimeException {
    public InvalidBoardNullException(String message) {
        super(message);
    }
}
