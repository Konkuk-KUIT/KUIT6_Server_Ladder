public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        validatePosition(position);
        return new Position(position);
    }

    private static void validatePosition(int position) {
        if (!isPosition(position)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

    // getter의 이름이 다 다르면 사용자는 이름을 추측해서 사용해야 함. 하지만 같다면...? 편할 수도
    // 그래서 getValue()로 통일시키는 경우도 있음
    public int getValue(){
        return position;
    }

    public void prev(){
        position--;
    }

    public void next(){
        position++;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }
}
