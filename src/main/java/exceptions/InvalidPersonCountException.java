package exceptions;

public class InvalidPersonCountException extends RuntimeException {
    public InvalidPersonCountException(String message) {
        super(message);
    }
}
