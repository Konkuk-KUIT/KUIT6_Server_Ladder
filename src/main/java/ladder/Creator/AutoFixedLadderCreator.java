package ladder.Creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;
import java.util.Random;

public class AutoFixedLadderCreator implements LadderCreator {
    private final Row[] rows;
    public AutoFixedLadderCreator(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRows.getNumber()];
        for (int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        drawLineAuto();
    }

    public Row[] getRows() {
        return rows;
    }

    public void drawLine(Position row, Position col){
        rows[row.getValue()].drawLine(col);
    }

    //todo 기존코드 사용해서 랜덤으로 사다리끼리 연결되게 제작(Line수 설정 && 의존성 주입)
    public void drawLineAuto() {
        //자동사냥
        Random rand = new Random();

        double p = 0.75; //선 생성 확률 조정

        /*rows가 이차원배열이 아니므로, 행별 제작이 옳을듯.
          확률적으로 생성되게 하고,
          생성되면 2칸 넘기기 아니면 1칸 넘기기
         */
        for (Row row : rows) {
            for (int j = 0; j < row.size() - 1; j++) {
                if (j < row.size() - 1 && rand.nextDouble() < p) {
                    row.drawLine(Position.from(j));
                    j++;
                }
            }
        }
    }
}
