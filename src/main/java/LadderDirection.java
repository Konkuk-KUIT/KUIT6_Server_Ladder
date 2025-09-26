public enum LadderDirection {
    Left("-"),
    Right("-"),
    None("|");

    private final String value;
    LadderDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
