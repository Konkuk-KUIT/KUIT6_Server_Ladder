package exception;

import message.ErrorMessage;

public class IllegalLadderNumberException extends RuntimeException {
    public IllegalLadderNumberException() {
        super(ErrorMessage.LADDER_NUM.getMessage());
    }
}
