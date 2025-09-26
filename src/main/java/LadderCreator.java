public class LadderCreator {
    private final Row[] rows;

    public LadderCreator(GreaterThanOne height, GreaterThanOne numberOfPerson) {
        rows = new Row[height.getNumber()];
        for(int i = 0; i < height.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public Row[] getLadder() {
        return rows;
    }

    public GreaterThanOne getHeight() {
        return GreaterThanOne.from(rows.length);
    }

    public GreaterThanOne getNumberOfPerson() {
        return GreaterThanOne.from(rows[0].getNodeLength());
    }

    public Row getLadderRow(int row) {
        return rows[row];
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    public void randomDrawLine(){
        final int totalLine = (int)Math.floor(getHeight().getNumber() * getNumberOfPerson().getNumber() * 0.3);
        for(int i = 0; i < totalLine; i++) {
            int row = (int)(Math.random() * getHeight().getNumber());
            int col = (int)(Math.random() * (getNumberOfPerson().getNumber() - 1));
            try{
                rows[row].drawLine(Position.from(col));
            }catch(IllegalArgumentException e){
                i--;
            }

        }
    }
}
