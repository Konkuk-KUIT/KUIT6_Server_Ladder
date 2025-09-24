package laddercreator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import position.Position;
import wrap.LadderHeight;
import wrap.PersonCount;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomLadderCreatorTest {

    @Test
    void 생성자_호출시_랜덤_라인이_자동생성된다() {
        PersonCount personCount = PersonCount.from(5);
        LadderHeight ladderHeight = LadderHeight.from(4);
        
        RandomLadderCreator creator = new RandomLadderCreator(personCount, ladderHeight);
        
        assertNotNull(creator);
        assertEquals(4, creator.getHeight());
        assertEquals(5, creator.getNumberOfPerson());
    }

    @Test
    void 생성된_라인_수가_총_가능한_라인_수의_30퍼센트_근처인지_확인() {
        PersonCount personCount = PersonCount.from(5);
        LadderHeight ladderHeight = LadderHeight.from(10);
        
        RandomLadderCreator creator = new RandomLadderCreator(personCount, ladderHeight);
        
        int totalPossibleLines = ladderHeight.getValue() * personCount.getMaxLineIndex(); // 10 * 4 = 40
        int expectedLines = (int) (totalPossibleLines * 0.3); // 12
        
        int actualLines = countGeneratedLines(creator);
        
        assertTrue(actualLines <= expectedLines + 2, "생성된 라인 수가 예상보다 너무 많습니다: " + actualLines);
        assertTrue(actualLines >= expectedLines - 2, "생성된 라인 수가 예상보다 너무 적습니다: " + actualLines);
    }

    @Test
    void 연속된_가로선이_생성되지_않는지_확인() {
        PersonCount personCount = PersonCount.from(5);
        LadderHeight ladderHeight = LadderHeight.from(10);
        
        RandomLadderCreator creator = new RandomLadderCreator(personCount, ladderHeight);
        
        for (int y = 0; y < ladderHeight.getValue(); y++) {
            for (int x = 0; x < personCount.getMaxLineIndex() - 1; x++) {
                Position current = Position.at(y, x);
                Position next = Position.at(y, x + 1);
                
                boolean currentHasConnection = creator.hasConnection(current);
                boolean nextHasConnection = creator.hasConnection(next);
                
                assertFalse(currentHasConnection && nextHasConnection, 
                    "연속된 가로선이 발견되었습니다: (" + y + "," + x + ") and (" + y + "," + (x+1) + ")");
            }
        }
    }

    @RepeatedTest(5)
    void 랜덤성_확인_매번_다른_패턴이_생성되는지() {
        PersonCount personCount = PersonCount.from(4);
        LadderHeight ladderHeight = LadderHeight.from(6);

        List<RandomLadderCreator> creators = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            creators.add(new RandomLadderCreator(personCount, ladderHeight));
        }

        boolean foundDifference = false;

        RandomLadderCreator first = creators.get(0);

        for (int i = 1; i < creators.size(); i++) {
            RandomLadderCreator current = creators.get(i);
            for (int y = 0; y < ladderHeight.getValue() && !foundDifference; y++) {
                for (int x = 0; x < personCount.getMaxLineIndex() && !foundDifference; x++) {
                    Position pos = Position.at(y, x);
                    if (first.hasConnection(pos) != current.hasConnection(pos)) {
                        foundDifference = true;
                    }
                }
            }
            if (foundDifference) break;
        }

        assertTrue(foundDifference, "10개의 인스턴스 중 적어도 하나는 다른 패턴을 가져야 합니다.");
    }

    private int countGeneratedLines(RandomLadderCreator creator) {
        int count = 0;
        for (int y = 0; y < creator.getHeight(); y++) {
            for (int x = 0; x < creator.getNumberOfPerson() - 1; x++) {
                Position pos = Position.at(y, x);
                if (creator.hasConnection(pos)) {
                    count++;
                }
            }
        }
        return count;
    }
}