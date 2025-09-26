import java.util.HashSet;
import java.util.Random;

public class AutoLadderCreator implements LadderCreator{
//    private final Row[] rows;
//    private final LadderSize ladderSize;
    private HashSet<Position>[] hashSets;
    private final ManualLadderCreator manualLadderCreator;

    public AutoLadderCreator(ManualLadderCreator manualLadderCreator) {
        this.manualLadderCreator = manualLadderCreator;
        for (int i = 0; i < manualLadderCreator.getLadderSize().getRow().getNumber(); i++) {
            hashSets[i] = new HashSet<Position>();
        }
    }

    private void autoDrawLines(){
        int numberOfLines = (int)(manualLadderCreator.getLadderSize().getRow().getNumber()*manualLadderCreator.getLadderSize().getNumberOfPerson().getNumber()*0.3);
       while(hashSets.length < numberOfLines) {
            Random rand = new Random();
            int randRow = rand.nextInt(manualLadderCreator.getLadderSize().getRow().getNumber());
            int randNumberOfPerson =rand.nextInt(manualLadderCreator.getLadderSize().getNumberOfPerson().getNumber());

            // contains: 내부에 값이 있다면 1, 없다면 0 출력
            if(hashSets[randRow].contains(Position.from(randNumberOfPerson))) continue;
            drawLine(Position.from(randRow), Position.from(randNumberOfPerson));
        }
    }

    public void drawLine(Position row, Position col){
        manualLadderCreator.drawLine(row, col);
    }

    public Row[] getRows() {
        return manualLadderCreator.getRows();
    }
}
