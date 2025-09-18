public class Ladder {

    // Row[] : 행의 배열
    private final Row[] rows;

    public Row[] getRows() {
        return rows;
    }

    // 사람 수가 곧 column의 수
    public Ladder(NaturalNumber rowCount, NaturalNumber numberOfPerson) {
        // 행 개수와 사람 수를 NaturalNumber에서 자연수인지 확인했으니 여기서는 확인할 필요가 없지 않을까??

        rows = new Row[rowCount.getNumber()];
        for (int rowIndex = 0; rowIndex < rowCount.getNumber(); rowIndex++)
            rows[rowIndex] = new Row(numberOfPerson);
    }

    public void drawLine(NaturalNumber rowIndex, NaturalNumber columnIndex) {
        if(rowIndex.getNumber() >= rows.length) throw new IllegalArgumentException("해당 행은 유효하지 않습니다.");

        rows[rowIndex.getNumber()].drawLine(columnIndex.getNumber());
    }
}
