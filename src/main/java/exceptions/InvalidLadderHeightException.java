package exceptions;

public class InvalidLadderHeightException extends RuntimeException {
  public InvalidLadderHeightException(String message) {
    super(message);
  }
}
