public interface LadderCreator {
    LadderLine[] getRows();
    void drawLine(PlayerPosition row, PlayerPosition col);
}