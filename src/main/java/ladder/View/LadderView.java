package ladder.View;

import ladder.ErrorMessage;
import ladder.Row;

public class LadderView {
    /**
     * rows에 들어있는 사다리를 출력하는 형태이다.
     * 별도의 형식 없이, 원본 그대로 출력한다(줄바꿈, 띄어쓰기 정도만 적용)
     */
//    public static void printRaw(Row[] rows, int rP, int cP) {
//        // 방어 코드: 비어있는지 체크
//        if (rows == null || rows.length == 0) {
//            throw new IllegalArgumentException(ErrorMessage.INVALID_GREATER_NO_LADDER.getMessage());
//        }
//        //NumberOfRows 구하기
//        int length = rows[0].size();
//        //구분선 출력
//        printTopLine(length);
//        //메인 출력부
//        for (int i = 0; i < rows.length; i++) {
//            String[] tokens = rows[i].toString().split("\\s+");
//            for (int j = 0; j < tokens.length; j++) {
//                if (i == rP && j == cP) {
//                    System.out.print(tokens[j] + "* ");
//                } else {
//                    System.out.print(tokens[j] + " ");
//                }
//            }
//            System.out.println();
//        }
//        //마지막 구분선 출력
//        printDivider(length);
//    }

    public static void printASCII(Row[] rows, int currentRow) {
        // 방어 코드: 비어있는지 체크
        if (rows == null || rows.length == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GREATER_NO_LADDER.getMessage());
        }
        //NumberOfRows 구하기
        int length = rows[0].size();
        //구분선 출력
        printTopLine(length);
        //메인 출력부 //이중반복문 로직 수정
        for (int i = 0; i < rows.length; i++) {
            if (i == currentRow) {System.out.println(rows[i].toStringCurrent());}
            else {System.out.println(rows[i].toString());}
        }
        //마지막 구분선 출력
        printDivider(length);
    }

    private static void printTopLine(int len) {
        if (len < 1) {
            return;
        }
        printDivider(len);
        for (int c = 0; c < len; c++) {
            System.out.print(c + " ");
        }
        System.out.println("\n" + "-".repeat(len * 2));
    }

    private static void printDivider(int len) {
        if (len >= 1) {
            System.out.println("=".repeat(len * 2));
        }
    }
}
