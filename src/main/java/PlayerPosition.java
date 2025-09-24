public class PlayerPosition {
    private final int position;

    public PlayerPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NATURAL_NUMBER.getMessage());
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    PlayerPosition move(int value){
        return new PlayerPosition(position + value);
    }
}
