package exceptions;

public class InvalidStartPositionException extends RuntimeException {
    public InvalidStartPositionException(String message) {
        super(message);
    }
}