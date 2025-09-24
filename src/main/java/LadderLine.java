import java.util.Arrays;

public class LadderLine {
    private final LadderDirection[] line;
    private final int playerCount;

    public LadderLine(int playerCount) {
        this.playerCount = playerCount;
        this.line = new LadderDirection[playerCount];

        Arrays.fill(line, LadderDirection.None);
    }

    public void drawLine(int position){
        if (position < 0 || position >= playerCount - 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
        line[position] = LadderDirection.Right;
        line[position + 1] = LadderDirection.Left;

    }

    public PlayerPosition move(PlayerPosition position) {
        int pos = position.getPosition();

        if (pos < playerCount - 1 && line[pos] == LadderDirection.Right) {
            return position.move(1);
        }
        if (pos > 0 && line[pos] == LadderDirection.Left) {
            return position.move(-1);
        }

        return position;
    }
}
