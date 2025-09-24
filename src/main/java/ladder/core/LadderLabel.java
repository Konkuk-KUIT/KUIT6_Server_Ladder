package ladder.core;

public enum LadderLabel {
    AFTER("AFTER\n"), BEFORE("BEFORE\n");

    private final String value;

    LadderLabel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
