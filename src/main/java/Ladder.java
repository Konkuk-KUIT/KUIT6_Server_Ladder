public class Ladder {

    private final Row[] rows;
    public Ladder(GreaterThanOne row, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, int col){
        rows[row].drawLine(col);
    }

    public void clearAllLines(){
        for(Row r:rows){
            r.clearRow();
        }
    }
    public int run(int position){
        //Before
        //int x=position;
        //int y=0;
        //Ladderposition(x,y);

        for(int i=0; i<rows.length-1; i++){
            System.out.println("// Before");
            printRowState(i,position);
            position = rows[i].nextPosition(position);
            System.out.println("// After");
            printRowState(i,position);

            //y=i;
        }
        //After
        //Ladderposition(x,y);
        return position;
    }

    private void printRowState(int currentRow, int currentCol) {
        for(int i=0; i<rows.length; i++) {
            int[] state = rows[i].getRowState();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < state.length; j++) {
                if (i==currentRow&&j==currentCol) {
                    sb.append(state[j]).append("* ");
                } else {
                    sb.append(state[j]).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
        System.out.println();
    }



    public Row[] getRows() {
        return rows;
    }
    /*
    private void Ladderposition(int row,int col) {
        StringBuilder sb=new StringBuilder();
        if(row>=0&&row<rows.length) {
            sb.append("*");
        }
        String result=sb.toString();
        System.out.println(result);
    }*/

}
