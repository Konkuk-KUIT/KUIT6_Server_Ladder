public enum Direction {
    Left(-1),
    Right(1),
    NONE(0);

    private final int value;
    Direction(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
