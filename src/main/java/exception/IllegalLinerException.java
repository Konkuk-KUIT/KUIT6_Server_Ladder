package exception;

import message.ErrorMessage;

public class IllegalLinerException extends RuntimeException {
    public IllegalLinerException() {
        super(ErrorMessage.LINER.getMessage());
    }
}
