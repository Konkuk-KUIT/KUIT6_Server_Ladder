public class NormalLadderCreator implements LadderCreator {

    @Override
    public Row[] getRows() {
        return rows;
    }

    private final Row[] rows;

    public NormalLadderCreator(GreaterThanOne row, GreaterThanOne numberOfPerson){
        rows = new Row[row.getValue()];
        for(int i = 0; i < row.getValue(); i++){
            rows[i] = new Row(numberOfPerson.getValue());
        }
    }

    public void drawLine(int row, int col){
        rows[row].drawLine(col);
    }

}
