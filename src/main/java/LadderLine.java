import java.util.Arrays;

public class LadderLine {
    private final LadderDirection[] line;
    private final GreaterThanOne playerCount;

    public LadderLine(GreaterThanOne playerCount) {
        this.playerCount = playerCount;
        this.line = new LadderDirection[playerCount.getNumber()];

        Arrays.fill(line, LadderDirection.None);
    }

    public void drawLine(int position){
        if (position < 0 || position >= playerCount.getNumber()-1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
        line[position] = LadderDirection.Right;
        line[position + 1] = LadderDirection.Left;

    }

    public PlayerPosition move(PlayerPosition position) {
        int pos = position.getPosition();

        if (pos < playerCount.getNumber() && line[pos] == LadderDirection.Right) {
            return position.move(1);
        }
        if (pos > 0 && line[pos] == LadderDirection.Left) {
            return position.move(-1);
        }

        return position;
    }
}
