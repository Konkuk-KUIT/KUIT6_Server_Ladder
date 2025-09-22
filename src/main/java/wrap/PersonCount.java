package wrap;

import exceptions.InvalidPersonCountException;
import exceptions.ErrorMessage;

import java.util.Objects;

public class PersonCount {

    private final int value;

    private PersonCount(int value) {
        if (value <= 0) {
            throw new InvalidPersonCountException(ErrorMessage.INVALID_PERSON_COUNT.getMessage());
        }
        this.value = value;
    }

    public static PersonCount of(int value) {
        return new PersonCount(value);
    }

    public int getValue() {
        return value;
    }

    public int getMaxLineIndex() {
        return value - 1;
    }

    public boolean isValidLineIndex(int lineIndex) {
        return lineIndex < 0 || lineIndex >= getMaxLineIndex();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonCount that = (PersonCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "PersonCount{" + "value=" + value + '}';
    }
}