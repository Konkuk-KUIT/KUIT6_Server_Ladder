import java.util.*;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(GreaterThanOne column, GreaterThanOne row) {
        LadderCreator ladderCreator = new LadderCreator(column, row);

        int line = (int)(column.getNum()*row.getNum()*0.3);

        HashSet<Position> set = new HashSet<>();

        /*
        * 교차점 범위
        * x: 0~(row-2)
        * y: 1~(col-2)
        * */
        while (set.size() != line) {
            Position p = Position.from(getRandomInt(0, row.getNum() - 2), getRandomInt(1, column.getNum() - 2));
            Position n = Position.from(p.getX()+1, p.getY());
            if (!p.canMoveRight(ladderCreator.getRows()) && !p.canMoveLeft(ladderCreator.getRows()) && !n.canMoveRight(ladderCreator.getRows())) {
                set.add(p);
                ladderCreator.drawLine(p);
            }
        }

        return new LadderGame(ladderCreator);
    }

    public static int getRandomInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
