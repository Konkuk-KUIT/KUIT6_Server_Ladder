package ladder.View;

import ladder.ErrorMessage;
import ladder.Row;

public class LadderView {
    /**
     * rows에 들어있는 사다리를 출력하는 형태이다.
     * 별도의 형식 없이, 원본 그대로 출력한다(줄바꿈, 띄어쓰기 정도만 적용)
     */
    public static void printRaw(Row[] rows,int rP,int cP) {
        // 방어 코드: 비어있는지 체크
        if (rows == null || rows.length == 0) {
            System.out.println(ErrorMessage.INVALID_GREATER_NO_LADDER.getMessage());
            return;
        }
        //NumberOfRows 구하기
        int length = rows[0].size();
        //구분선 출력
        printTopLine(length);
        //메인 출력부
        for (int i = 0; i < rows.length; i++) {
            String[] tokens = rows[i].toString().split("\\s+");
            for (int j=0; j < tokens.length; j++) {
                if (i == rP && j==cP) {
                    System.out.print(tokens[j] + "* ");
                } else {
                    System.out.print(tokens[j] + " ");
                }
            }
            System.out.println();
        }
        //마지막 구분선 출력
        printDivider(length);
    }

    public static void printASCII(Row[] rows,int rP,int cP) {
        // 방어 코드: 비어있는지 체크
        if (rows == null || rows.length == 0) {
            System.out.println(ErrorMessage.INVALID_GREATER_NO_LADDER.getMessage());
            return;
        }
        //NumberOfRows 구하기
        int length = rows[0].size();
        //구분선 출력
        printTopLine(length);
        //메인 출력부
        for (int i = 0; i < rows.length; i++) {
            String[] tokens = rows[i].toString().split("\\s+");
            StringBuilder line = new StringBuilder();

            for (int j=0; j < tokens.length; j++) {
                line.append((i == rP && j == cP) ? "*" : "|");
                if (j < tokens.length - 1) {
                    boolean connected =
                            "1".equals(tokens[j]) || "-1".equals(tokens[j + 1]);
                    line.append(connected ? "-" : " ");
                }
            }
            System.out.println(line);
        }
        //마지막 구분선 출력
        printDivider(length);
    }

    private static void printTopLine(int len){
        printDivider(len);
        for (int c = 0; c < len; c++) { System.out.print(c + " "); }
        System.out.println("\n" + "-".repeat(len*2));
    }

    private static void printDivider(int len){
        System.out.println("=".repeat(len*2));
    }



}
