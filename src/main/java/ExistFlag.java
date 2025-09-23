public enum ExistFlag {
    EXIST(1),
    NON_EXIST(0);

    private final int value;

    ExistFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
