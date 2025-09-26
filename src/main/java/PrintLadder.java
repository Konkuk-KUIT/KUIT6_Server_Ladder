public class PrintLadder {
    private final LadderCreator ladderCreator;

    public PrintLadder(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public void print(Position position) {
        GreaterThanOne totalHeight = ladderCreator.getHeight();
        for(int currentHeight = 0; currentHeight < totalHeight.getNumber(); currentHeight++) {
            beforePrint(currentHeight, position);
            ladderCreator.getLadder()[currentHeight].goToNext(position);
            afterPrint(currentHeight, position);
        }
    }

    private void afterPrint(int currentHeight, Position position) {
        GreaterThanOne totalHeight = ladderCreator.getHeight();
        System.out.println("After");
        for(int row = 0; row < totalHeight.getNumber(); row++) {
//            printRows(isCurrent(currentHeight, col), position);
            printNodes(ladderCreator.getLadderRow(row), isCurrent(currentHeight, row), position);
        }
    }

    private void beforePrint(int currentHeight, Position position) {
        GreaterThanOne totalHeight = ladderCreator.getHeight();
        System.out.println("Before");
        for(int row = 0; row < totalHeight.getNumber(); row++) {
//            printRows(isCurrent(currentHeight, col), position);
            printNodes(ladderCreator.getLadderRow(row), isCurrent(currentHeight, row), position);
        }
    }

    private static boolean isCurrent(int currentHeight, int col) {
        return currentHeight == col;
    }

    private void printRows(boolean isCurrent, Position position) {
        GreaterThanOne rowLength = ladderCreator.getNumberOfPerson();
        for(int nodeIndex = 0; nodeIndex < rowLength.getNumber(); nodeIndex++){
            Row row = ladderCreator.getLadderRow(nodeIndex);
            printNodes(row, isCurrent, position);
        }
    }

    private void printNodes(Row row, boolean isCurrent, Position position) {
        StringBuilder[] rowValues = row.getNodeValues();
        if(isCurrent) {
            markingPosition(rowValues, position);
        }
        for (StringBuilder rowValue : rowValues) {
            System.out.print(rowValue.append(" "));
        }
        System.out.println();
    }

    private void markingPosition(StringBuilder[] rowValues, Position position) {
        rowValues[position.getPosition()].append("*");
    }
}
