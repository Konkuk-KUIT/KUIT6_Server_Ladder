package ladderMaker;

public enum RandomRatio {
    RANDOM_LINE(0.3);

    private final double value;

    public double getValue() {
        return value;
    }

    RandomRatio(double value) {
        this.value = value;
    }
}
