public class Ladder {

    private final int[][] rows;

    public Ladder(int height, int numberOfPerson) {
        rows = new int[height][numberOfPerson];
    }

    public void drawLine(Position position){
        int currentHeight = position.getHeight();
        int currentRow = position.getRow();
        rows[currentHeight][currentRow] = position.getIsToLeft() ? -1 : 1;
        if(position.getIsToLeft()) rows[currentHeight][currentRow - 1] = 1;
        else rows[currentHeight][currentRow + 1] = -1;
    }

    public int run(int selectedIndex) {
        int ladderHeight = rows.length;
        int currentLine = selectedIndex;
        for(int i = 0; i < ladderHeight; i++){
            currentLine += rows[i][currentLine];
        }
        return currentLine;
    }
}
