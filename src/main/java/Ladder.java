import java.util.*;
import java.util.Random;

/**
 * Ladder는 사다리를 생성하는 drawLine() 메서드와
 * 그려진 사다리를 실제 타보는 run() 메서드를 중심으로 이루어져있다.
 * 사다리를 그리는 drawLine() 메서드는 drawBasicLines() 메서드와 makeHorizontalLine()을 사용한다.
 * drawLadder() 메서드는 출력을 담당하며, 테스트및 확장을 위해 존재한다.
 * (다만 실제, 확장시 출력은 별도의 클래스에서 담당할 듯하다.)
 */
public class Ladder {

    /**
     * 사다리를 표현하는 이차원 Int배열
     */
    private final int[][] rows;

    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        rows = new int[row.getNumber()][numberOfPerson.getNumber()];
    }

    /**
     *  drawBasicLines()로 rows를 초기화하고,
     *  makeHorizontalLine()으로 가로줄을 구현한다.
     */
    public void drawLine(){
        drawBasicLines();

        // 2) 각 행에 가로줄(= 인접 스왑) 적용
        for (int c = 0; c < rows[0].length-1; c++) {
            List<Integer> picked_rows = makeHorizontalLine(c);
            //System.out.println(c + " " + picked_rows); //디버깅을 위한 출력구문
            for (int r : picked_rows) {
                int a = rows[r][c];
                int b = rows[r][c + 1];
                rows[r][c]     = b;
                rows[r][c + 1] = a;
            }
        }
    }


    /**
     * drawLine()으로 만들어진 사다리를 타고, 내려가 결과값을 반환해준다.
    **/
    public int run(NaturalNumber col_natural) {//shift + F6누르면, 변수 이름 한번에 변경 가능
        int col = col_natural.getNumber();
        col -= 1; //실제 좌표 0~rows[0].length-1이 사용자한텐 1~rows[0].length일 것을 고려한다.
        if(col < 0 || col > rows[0].length-1) {
            throw new IllegalArgumentException();
        }
        for (int[] row : rows) {
            if (row[col] != col) {
                col = row[col];
            }
        }
        return col;
    }



    /**
     * @return
     * 이전 열에 가로줄이 없는 부분만 골라서,
     * 다음 열과 연결한다.
     * 0-1-2 같은 상황을 방지하며, 0-1,2-3 같은 상황은 허용한다.
     */
    private List<Integer> makeHorizontalLine(int col) {
        //if (col < 0 || col > rows[0].length-1) {throw new IllegalArgumentException();}
        //예외처리는 만들어 두었으나, makeHorizontalLine에 위 조건문에 해당하는 값이 들어올 가능성이 없어, 주석처리
        Random rand = new Random();
        List<Integer> picked = new ArrayList<>();

        for (int r = 1; r < rows.length-1; r++) {
            if (col > 0 && rows[r][col-1] != col-1) {
                continue;
            }
            if (rand.nextBoolean()) {
                picked.add(r);
                r++;
            }
        }//format 명령어 찾아보기(intelliji / for문등에서
        return picked;
    }

    /**
     * 기본적인 열별 숫자 배열(0~N)을 담당하는 drawLine()메서드의 하위 메서드이다.
     * 메서드 간소화||분리 법칙을 위해 제작
     */
    private void drawBasicLines() {
        for (int r = 0; r < rows.length; r++) {
            for (int c = 0; c < rows[0].length; c++) {
                rows[r][c] = c;
            }
        }
    }

    /**
     * LadderView에 출력을 위해 rows 자체가 아닌 복제본을 넘겨줌
     * @return
     */
    public int[][] snapshot() {
        int[][] copy = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            copy[i] = rows[i].clone();
        }
        return copy;
    }
}
