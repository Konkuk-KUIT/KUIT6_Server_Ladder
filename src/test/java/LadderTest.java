import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class LadderTest {
    @Test
    @DisplayName("선그리기")
    public void DrawlineAndRun(){
        Ladder ladder = new Ladder(3,4);
        ladder.drawline(0,0);
        ladder.drawline(1, 2);
        ladder.drawline(2, 3);

        assertEquals(1,ladder.run(0));
        assertEquals(3,ladder.run(2));
        assertEquals(3,ladder.run(3));
    }

    @Test
    @DisplayName("선을 그리지 않음")
    public void InValidLine(){
        Ladder ladder = new Ladder(3,4);
        assertEquals(0,ladder.run(0));
        assertEquals(1,ladder.run(1));
        assertEquals(2,ladder.run(2));
    }

    @Test
    @DisplayName("선을 이상한곳에다가 그림")
    public void StrangeLine(){
        Ladder ladder = new Ladder(3,4);
        ladder.drawline(-1,0);
        ladder.drawline(10,10);
        assertEquals(0,ladder.run(0));
        assertEquals(1,ladder.run(1));
    }
}