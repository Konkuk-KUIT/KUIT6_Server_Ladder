import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("Ladder create - valid input")
    public void createLadder() {
        Ladder ladder = new Ladder(4, 4);
        Assertions.assertNotNull(ladder);
    }

    @Test
    @DisplayName("Ladder create - invalid input")
    public void createLadderInvalidInput(){
        Assertions.assertThrows(Exception.class, ()->{new Ladder(0,0);}) ;
        Assertions.assertThrows(Exception.class, ()->{new Ladder(-1,4);}) ;
        Assertions.assertThrows(Exception.class, ()->{new Ladder(4,-1);}) ;
        Assertions.assertThrows(Exception.class, ()->{new Ladder(-1,-1);}) ;


    }

    @Test
    @DisplayName("drawline - valid input")
    public void drawline() {
        Ladder ladder = new Ladder(4, 4);
        //경계값 테스트
        ladder.drawline(0,0);
        ladder.drawline(0,2);
        ladder.drawline(3,0);
        ladder.drawline(3,2);
    }
    
    @Test
    @DisplayName("drawline - invalid input - out of bound")
    public void drawlineInvalidInput(){
        Ladder ladder = new Ladder(4, 4);
        // col값 초과
        Assertions.assertThrows(Exception.class, ()->{ladder.drawline(0,3);});
        Assertions.assertThrows(Exception.class, ()->{ladder.drawline(3,3);});

        // col값 미달
        Assertions.assertThrows(Exception.class, ()->{ladder.drawline(0,-1);});
        Assertions.assertThrows(Exception.class, ()->{ladder.drawline(3,-1);});

        // row값 초과
        Assertions.assertThrows(Exception.class, ()->{ladder.drawline(4,0);});
        Assertions.assertThrows(Exception.class, ()->{ladder.drawline(4,2);});

        // row값 미만
        Assertions.assertThrows(Exception.class, ()->{ladder.drawline(-1,0);});
        Assertions.assertThrows(Exception.class, ()->{ladder.drawline(-1,2);});
    }

    @Test
    @DisplayName("drawline - invalid input -  already exist")
    public void drawlineDuplicated(){
        Ladder ladder = new Ladder(4, 4);
        ladder.drawline(0,1);
        Assertions.assertThrows(Exception.class, ()->{ladder.drawline(0,1);});
        Assertions.assertThrows(Exception.class, ()->{ladder.drawline(0,2);});
    }
    
    @Test
    @DisplayName("run - no drawline")
    public void runNoDrawline() {
        Ladder ladder = new Ladder(4, 4);
        Assertions.assertEquals(0, ladder.run(0));
        Assertions.assertEquals(1, ladder.run(1));
        Assertions.assertEquals(2, ladder.run(2));
        Assertions.assertEquals(3, ladder.run(3));
    }

    @Test
    @DisplayName("run - with drawline")
    public void runDrawline() {
        Ladder ladder = new Ladder(4, 4);

        ladder.drawline(0,0);
        ladder.drawline(0,2);
        ladder.drawline(1,1);
        ladder.drawline(2,0);
        ladder.drawline(3,1);

        Assertions.assertEquals(1, ladder.run(0));
        Assertions.assertEquals(2, ladder.run(1));
        Assertions.assertEquals(3, ladder.run(2));
        Assertions.assertEquals(0, ladder.run(3));
    }

}