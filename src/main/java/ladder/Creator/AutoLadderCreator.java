package ladder.Creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;
import java.util.List;
import java.util.Random;

public class AutoLadderCreator implements LadderCreator {

    private final Row[] rows;
    public AutoLadderCreator(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
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
        List<int[]> plan = RandomManager.generatePlan(rows, rand); //어느 Row의 어느 Node에 가로줄 그을지 판단 생성
        //plan.forEach(arr -> System.out.println(Arrays.toString(arr))); //Test 코드
        //실제 줄 생성
        for (int[] rc : plan) {
            int r = rc[0], c = rc[1];
            rows[r].drawLine(Position.from(c)); // c—c+1 연결
            System.out.println(r + " " + c);
        }
    }
}
