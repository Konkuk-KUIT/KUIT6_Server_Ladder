public class LadderCreator {

    private final LadderLine[] rows;
    public LadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new LadderLine[numberOfRow.getNumber()];
        for(int i=0; i<numberOfRow.getNumber(); i++){
            rows[i] = new LadderLine(numberOfPerson);
        }
    }

    public LadderLine[] getRows(){
        return rows;
    }

    public void drawLine(PlayerPosition row, PlayerPosition col){ rows[row.getValue()].drawLine(col);}
}
