package exception;

import message.ErrorMessage;

public class IllegalSequenceException extends RuntimeException {
    public IllegalSequenceException() {
        super(ErrorMessage.SEQUENCE.getMessage());
    }
}
