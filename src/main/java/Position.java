public class Position {
    private int position;

    private Position(int position){
        this.position = position;
    }
    public static Position from(int position){
        return new Position(position);
    }

    public int getPosition() {
        return position;
    }

    private static void validatePosition(int position){
        if(!isPosition(position)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

    public void prev() {
        position--;
    }
    public void next() {
        position++;
    }

    public boolean isBiggerThan(int positionMax) {
        return position > positionMax;
    }
}
