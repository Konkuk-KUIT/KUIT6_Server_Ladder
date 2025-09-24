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
        validatePosition(position);
        int pos = position.getValue();

        if (line[pos] == LadderDirection.Right) {
            return position.next();
        }
        if (line[pos] == LadderDirection.Left) {
            return position.prev();
        }
        return position;
    }

    private void validatePosition(PlayerPosition position){
        if(position.getValue() >= line.length || position.getValue() <0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }
}
