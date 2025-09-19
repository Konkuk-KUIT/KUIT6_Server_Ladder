import java.util.Scanner;

public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    // 선 그리기
    public void drawline(int row, int col) {
        if (isValidPosition(row, col)) {
            rows[row][col] = 1;
        }
    }

    public int run(int start) {
        int position = start;
        for (int row = 0; row < rows.length; row++) {
            if (moveleft(row, position)) {
                position--;
            }
            if (moveright(row, position)) {
                position++;
            }
        }
        return position;
    }

    private boolean moveright(int row, int position) {
        return rows[row][position] == 1 && position < rows[0].length-1;
    }

    private boolean moveleft(int row, int position) {
        return position > 0 && rows[row][position - 1] == 1;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows.length && col >= 0 && col < rows[0].length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("사다리 높이 입력: ");
        int height = scanner.nextInt();

        System.out.print("참여자 수 입력: ");
        int numPlayers = scanner.nextInt();

        Ladder ladder = new Ladder(height, numPlayers);
        System.out.print("가로선 개수 입력: ");
        int lineCount = scanner.nextInt();

        for (int i = 0; i < lineCount; i++) {
            System.out.print("가로선 위치 입력 (행 열): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            ladder.drawline(row, col);
        }

        System.out.print("시작 위치 입력: ");
        int start = scanner.nextInt();

        int result = ladder.run(start);
        System.out.println("사다리 결과: " + result);
    }

}
