public class DefaultLadderCreator implements LadderCreator{
    private Row[] rows;

    @Override
    public Row[] create(int rowSize, int numberOfPerson) {
        rows = new Row[rowSize];
        for (int i = 0; i<rowSize;i++) {
            rows[i] = new Row(numberOfPerson);
        }
        return rows;
    }

    //constructor
//    //Todo: int type wrapper로 감싸기
//    public DefaultLadderCreator(int rowSize, int numberOfPerson) {
//        rows = new Row[rowSize];
//        for (int i = 0; i<rowSize;i++) {
//            rows[i] = new Row(numberOfPerson);
//        }
//    }


    public Row[] getRows() {
        return rows;
    }

    @Override
    public void drawLine(Position position) {
        int positionRow = position.getRow();
        //하나의 row(높이)에 2개 이상의 사다리 허용x
        if (!rows[positionRow].canDrawLine()) //입력받은 idx번째 row를 들고와서 검사
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());

        //입력 받은 col과 col+1 에 가로줄 연결 -> 입력되는 col은 0~numberOfPerson-2까지만 허용
        //각 position 이 유효한지 직접 검사함
        if(position.isValid(rows.length-1, rows[0].rowSize-2)) {
            rows[positionRow].drawRow(position.getCol());
            rows[positionRow].drawRow(position.getCol()+1);
        }
    }
}
