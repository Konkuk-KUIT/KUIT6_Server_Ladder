import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    @Override
    public Row[] getRows() {
        return normalLadderCreator.getRows();
    }

    private final NormalLadderCreator normalLadderCreator;

    public RandomLadderCreator(GreaterThanOne row, GreaterThanOne numberOfPerson){
        this.normalLadderCreator = new NormalLadderCreator(row, numberOfPerson);
        drawRandomLine(row, numberOfPerson);

    }

    private void drawRandomLine(GreaterThanOne row, GreaterThanOne numberOfPerson) {
        int lineCount = (int) (row.getValue() * numberOfPerson.getValue() * 0.3);
        Random random = new Random();
        while(lineCount > 0){
            int i = random.nextInt(row.getValue());
            int j = random.nextInt(numberOfPerson.getValue()-1);
            try{
                drawLine(i,Position.from(j));
                lineCount--;
            }
            catch(Exception e){
//                System.out.println("이미 생성된 라인입니다");
            }
        }

    }

    private void drawLine(int row, Position col){
        this.getRows()[row].drawLine(col);
    }
}
