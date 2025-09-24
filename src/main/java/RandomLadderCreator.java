import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    @Override
    public Row[] getRows() {
        return rows;
    }

    private final Row[] rows;

    public RandomLadderCreator(GreaterThanOne row, GreaterThanOne numberOfPerson){
        rows = new Row[row.getValue()];
        for(int i = 0; i < row.getValue(); i++){
            rows[i] = new Row(numberOfPerson.getValue());
        }
        drawRandomLine(row, numberOfPerson);
    }

    private void drawRandomLine(GreaterThanOne row, GreaterThanOne numberOfPerson) {
        int lineCount = (int) (row.getValue() * numberOfPerson.getValue() * 0.3);
        Random random = new Random();
        while(lineCount > 0){
            int i = random.nextInt(row.getValue());
            int j = random.nextInt(numberOfPerson.getValue()-1);
            try{
                drawLine(i,j);
                lineCount--;
            }
            catch(Exception e){
                System.out.println("이미 생성된 라인입니다");
            }
        }

    }

    private void drawLine(int row, int col){
        rows[row].drawLine(col);
    }
}
