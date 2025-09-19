package exceptions;

public class DuplicateLineException extends RuntimeException {
    public DuplicateLineException(String message) {
        super(message);
    }
}