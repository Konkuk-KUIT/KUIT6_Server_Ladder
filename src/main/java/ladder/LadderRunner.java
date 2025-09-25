package ladder;

import ladder.View.LadderView;

/**
 * 사다리의 이동을 계산하는 run() 메서드를 관리 및 실행하는 클래스
 * run() 메서드에서는 LadderView 클래스의 정적 메서드 printASCII()를 실행하여 이동과정을 단계별로 보여준다.
 */
public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position){
        for (int i = 0; i < rows.length; i++) {
            rows[i].setCurrentPosition(position);
            LadderView.printASCII(rows,i);
            if(rows[i].nextPosition(position)) {
                LadderView.printASCII(rows, i);
            }
        }
        return position.getValue();
    }
}
