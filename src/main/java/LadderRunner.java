public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(int startX) {
        validStartPosition(startX);
        int finalX = startX;
        for (Row row : rows) {
            finalX = row.getNextPosition(finalX);
        }

        return finalX;
    }

    // valid methods

    private void validStartPosition(int startX) {
        if (startX < 0 || startX >= rows[0].getLength()) {
            throw new ArrayIndexOutOfBoundsException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }
}
