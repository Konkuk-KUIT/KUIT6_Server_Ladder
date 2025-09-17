

public class LadderView {
    /**
     * rows에 들어있는 사다리를 출력하는 형태이다.
     * 별도의 형식 없이, 원본 그대로 출력한다(줄바꿈, 띄어쓰기 정도만 적용)
     */
    public static void printRaw(Ladder ladder) {
        int[][] rows = ladder.snapshot();
        for (int c = 1; c < rows[0].length+1; c++) { System.out.print(c + " "); }
        System.out.println("\n" + "-".repeat(rows[0].length*2));
        for (int[] row : rows) {
            for (int i : row) {
                System.out.print(i+1 + " ");
            }
            System.out.println();
        }
    }

    public static void printAscii(Ladder ladder) {
        int[][] rows = ladder.snapshot();
        int cols = rows[0].length;

        for (int c = 1; c <= cols; c++) System.out.print(c + " ");
        System.out.println();
        System.out.println("-".repeat(cols * 2));

        for (int[] row : rows) {
            for (int c = 0; c < cols; c++) {
                System.out.print("|");
                if (c < cols - 1 && row[c] == c + 1 && row[c + 1] == c) {
                    System.out.print("-");
                } else if (c < cols - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
