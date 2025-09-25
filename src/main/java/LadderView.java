public class LadderView {

    public String getLadderString(Ladder ladder, int currentRow, int currentPosition) {
        if (ladder == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_LADDER_NULL.getMessage());
        }

        Row[] rows = ladder.getRows();
        if (rows.length == 0) {
            return "";
        }

        int numberOfPeople = ladder.getNumberOfPerson().getNumber();
        if (currentRow < 0 || currentRow >= rows.length || currentPosition < 0 || currentPosition >= numberOfPeople) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_POSITION.getMessage());
        }

        StringBuilder sb = new StringBuilder();
        String padding = "  ";

        for (int i = 0; i < rows.length; i++) {
            sb.append(padding);
            for (int j = 0; j < numberOfPeople; j++) {
                if (i == currentRow && j == currentPosition) {
                    sb.append("*");
                } else {
                    sb.append("|");
                }

                if (j < numberOfPeople - 1) {
                    if (rows[i].getLadderStates()[j] == LadderDirections.RIGHT) {
                        sb.append("-----");
                    } else {
                        sb.append("     ");
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}