package creator;

import domain.Row;

public interface LadderCreator {
    void drawLine(int row, int person);
    Row[] getRows();
}
