public class Rows {
    private final int[][] rows;

    public Rows(int row, int numberOfPerson) {
        this.rows = new int [row][numberOfPerson];
    }
    public int getRows(int row, int numberOfPerson) {
        return rows[row][numberOfPerson];
    }
    public int row() {
        return rows.length;
    }
    public int numberOfPerson() {
        return rows[0].length;
    }
    public void drawLine(int row, int position) {
        if(row == 0) {
            System.out.println("row 2줄 이상부터 가능합니다.");
            throw new IllegalArgumentException();
        }
        if(position == numberOfPerson() - 1) {
            System.out.println("사다리의 마지막 세로줄에는 선을 그을 수 없습니다.");
            throw new IllegalArgumentException();
        }
        if(rows[row][position] != 0) {
            System.out.println("연속으로 줄을 그을 수 없습니다.");
            throw new IllegalArgumentException();
        }
        this.rows[row][position] = 1;
        this.rows[row][position+1] = -1;
    }

}
