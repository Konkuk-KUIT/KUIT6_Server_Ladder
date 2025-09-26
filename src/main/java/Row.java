public class Row {
    private int[] row;
    public final int rowSize;

    //constructor
    public Row(int size) {
        this.row = new int[size];
        this.rowSize = size;
    }

    public boolean canDrawLine() { //사다리 중복 여부 검사
        for (int i : row) {
            if (i == 1)
                return false;
        }
        return true;
    }

    public void showRow(int presCol) { //ladder 보여주는 함수
        for (int i = 0; i < row.length; i++) {
            System.out.print(presCol == i ? row[i] + "* " : row[i] + "  ");
        }
    }

    public void showTotalRow() {
        for (int i : row) {
            System.out.print(i + " ");
        }
    }

    public int moveCoord(int startColNumber) {
        //Todo: rowsize-1 인가?
        int pos = startColNumber;
        if (pos <= rowSize - 2 && row[pos + 1] == 1) { //오른쪽 길이 있는 경우(1칸만 이동)
//            System.out.println("right presColNumber: "+pos);
            return ++pos;
        }
        if (pos >= 1 && row[pos - 1] == 1) { //왼쪽 길이 있는 경우
//            System.out.println("left presColNumber: "+pos);
            return --pos;
        }
        return pos;
    }

    public void drawRow(int colIdx) { //row에서 직접 사다리를 그림
        row[colIdx] = 1;
    }

    //row가 겹쳐지지 않는지, 연속되지 않는 지 검사하는 메서드
    public boolean isLineOccupied(int positionCol) {
        if(positionCol==0)
            return row[positionCol+2]==1||row[0]==1;
        if(positionCol==rowSize-2)
            return row[positionCol-1]==1||row[positionCol]==1;
        return row[positionCol-1]==1||row[positionCol+2]==1||row[positionCol]==1;
    }
}