import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    private Row[] rows;
    private int lineNumber;

    //난수 생성 변수
    Random random = new Random();

    @Override
    public Row[] create(int rowSize, int numberOfPerson) {
        rows = new Row[rowSize];
        for (int i = 0; i<rowSize;i++) {
            rows[i] = new Row(numberOfPerson);
        }
        this.lineNumber = (int) (rowSize * numberOfPerson * 0.3);
        return rows;
    }

    @Override
    public void drawLine(Position position) {
        int count=0;
        int positionRow, positionCol;
        random.setSeed(System.currentTimeMillis());
        while(count<lineNumber){
            positionRow = random.nextInt(rows.length);
            positionCol = random.nextInt(rows[0].rowSize-1);
            //중복 검사
            if(validate(positionRow, positionCol)){
                rows[positionRow].drawRow(positionCol);
                rows[positionRow].drawRow(positionCol+1);
                count++;
            }
        }
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    private boolean validate(int positionRow, int positionCol) {
        if(!rows[positionRow].isLineOccupied(positionCol))
            return true;
        return false;
    }
}
