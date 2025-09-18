public class PlayerPosition {
    private final int position;

    public PlayerPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이상이여야 합니다.");
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
