package exception;

import message.ErrorMessage;

public class IllegalHeightException extends RuntimeException {
    public IllegalHeightException() {
        super(ErrorMessage.HEIGHT.getMessage());
    }
}
