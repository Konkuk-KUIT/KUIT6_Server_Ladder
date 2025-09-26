public class LadderRunner {
    private final Ladder ladder;

    public LadderRunner(Ladder ladder) {
        this.ladder = ladder;
    }

    public int run(int startPosition) {
        return run(startPosition, LadderTraversalObserver.noop());
    }

    public int run(int startPosition, LadderTraversalObserver observer) {
        validateStartPosition(startPosition);
        int currentPosition = startPosition;
        Row[] rows = ladder.getRows();
        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            Row row = rows[rowIndex];
            observer.beforeStep(rowIndex, currentPosition, ladder);
            if (row.connectsToRightFrom(currentPosition)) {
                currentPosition++;
            } else if (row.connectsToLeftFrom(currentPosition)) {
                currentPosition--;
            }
            observer.afterStep(rowIndex, currentPosition, ladder);
        }
        return currentPosition;
    }

    private void validateStartPosition(int startPosition) {
        if (startPosition < 0 || startPosition >= ladder.getNumberOfPerson()) {
            throw new IllegalArgumentException("Invalid start position: " + startPosition);
        }
    }
}