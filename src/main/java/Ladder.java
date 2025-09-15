public class Ladder {

    private final int[][] rows;

    public Ladder(NoneNegative height, NoneNegative numberOfPerson) {
        rows = new int[height.getNumber()][numberOfPerson.getNumber()];
    }

    public void drawLine(Position position){
        NoneNegative currentHeight = position.getHeight();
        NoneNegative currentRow = position.getRow();
        drawableLine(currentRow, currentHeight);  // drawLine의 입력값 유효성 체크

        rows[currentHeight.getNumber()][currentRow.getNumber()] = position.getIsToLeft() ? -1 : 1;
        if(position.getIsToLeft()) rows[currentHeight.getNumber()][currentRow.getNumber() - 1] = 1;
        else rows[currentHeight.getNumber()][currentRow.getNumber() + 1] = -1;
    }

    public int run(int selectedIndex) {
        int ladderHeight = rows.length;
        int currentLine = selectedIndex;
        for(int i = 0; i < ladderHeight; i++){
            currentLine += rows[i][currentLine];
        }
        return currentLine;
    }

    public void drawableLine(NoneNegative currentRow, NoneNegative currentHeight) {
        if(currentRow.getNumber() >= rows[0].length) throw new IllegalArgumentException();
        if(currentHeight.getNumber() >= rows.length) throw new IllegalArgumentException();
    }
}
