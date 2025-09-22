package ladderboard;

public enum LineDirection {
    NONE(0),
    RIGHT(1),
    LEFT(-1);
    
    private final int value;
    
    LineDirection(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}