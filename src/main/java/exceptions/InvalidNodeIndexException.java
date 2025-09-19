package exceptions;

public class InvalidNodeIndexException extends RuntimeException {
    public InvalidNodeIndexException(String message) {
        super(message);
    }
}
