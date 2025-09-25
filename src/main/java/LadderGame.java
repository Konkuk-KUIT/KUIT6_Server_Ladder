public class LadderGame
{
    public NaturalNumber runGame(Ladder ladder, NaturalNumber startLadderNumber)
    {
        int position = startLadderNumber.getNumber() - 1;
        Row[] rows = ladder.getRows();

        if (startLadderNumber.getNumber() > rows[0].getLadderStates().length) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_POSITION.getMessage());
        }

        for (int i = 0; i < rows.length; i++) {
            switch(rows[i].getLadderStates()[position]) {
                case LEFT -> position--;
                case RIGHT -> position++;
            }
        }

        return NaturalNumber.from(position + 1);
    }
}