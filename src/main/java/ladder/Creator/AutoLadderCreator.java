package ladder.Creator;

import ladder.Domain.GreaterThanOne;
import ladder.Domain.Position;
import ladder.Domain.Row;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class AutoLadderCreator implements LadderCreator {
    private final int row;
    private final int column;
    private final Row[] rows;
    private final Random random = new Random();

    public AutoLadderCreator(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRows.getNumber()];
        for (int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        row = numberOfRows.getNumber();
        column = numberOfPerson.getNumber();
        autoDrawLines(numberOfRows, numberOfPerson);
    }

    private void autoDrawLines(GreaterThanOne numberOfRows, GreaterThanOne numberOfPerson) {
        int totalLines = (numberOfRows.getNumber()*numberOfPerson.getNumber())/3;
        HashSet<String> numbers = new HashSet<>();
        while (numbers.size() <= ((row*column)/3)) {
            addNumber(numbers);
        }
    }

    private void addNumber(HashSet<String> numbers) {
        Position rowPosition = Position.from(random.nextInt(row));
        Position colPosition = Position.from(random.nextInt(column - 1));        String key = rowPosition.getValue()+","+ colPosition.getValue();
        if (numbers.contains(key)) return; // 이미 있으면 패스
        try {
            drawLine(rowPosition, colPosition);
            numbers.add(key);
            System.out.println(key);
        } catch (IllegalArgumentException e) {

        }
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }
}