import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    @Test
    @DisplayName("LadderGame create - valid input")
    public void createLadderGame() {
        LadderGame ladder = new LadderGame(new NormalLadderCreator(GreaterThanOne.from(4),GreaterThanOne.from(4)));
        Assertions.assertNotNull(ladder);
    }

    @Test
    @DisplayName("LadderGame create - invalid input")
    public void createLadderGameInvalidInput(){
        Assertions.assertThrows(Exception.class, ()-> new LadderGame(new NormalLadderCreator(GreaterThanOne.from(0),GreaterThanOne.from(0)))) ;
        Assertions.assertThrows(Exception.class, ()-> new LadderGame(new NormalLadderCreator(GreaterThanOne.from(-1),GreaterThanOne.from(4)))) ;
        Assertions.assertThrows(Exception.class, ()-> new LadderGame(new NormalLadderCreator(GreaterThanOne.from(4),GreaterThanOne.from(-1)))) ;
        Assertions.assertThrows(Exception.class, ()-> new LadderGame(new NormalLadderCreator(GreaterThanOne.from(-1),GreaterThanOne.from(1)))) ;


    }

    @Test
    @DisplayName("drawLine - valid input")
    public void drawLine() {
        NormalLadderCreator ladderCreator = new NormalLadderCreator(GreaterThanOne.from(4), GreaterThanOne.from(4));
        //경계값 테스트
        ladderCreator.drawLine(0,Position.from(0));
        ladderCreator.drawLine(0,Position.from(2));
        ladderCreator.drawLine(3,Position.from(0));
        ladderCreator.drawLine(3,Position.from(2));
    }
    
    @Test
    @DisplayName("drawLine - invalid input - out of bound")
    public void drawLineInvalidInput(){
        NormalLadderCreator ladderCreator = new NormalLadderCreator(GreaterThanOne.from(4), GreaterThanOne.from(4));
        // col값 초과
        Assertions.assertThrows(Exception.class, ()-> ladderCreator.drawLine(0,Position.from(3)));
        Assertions.assertThrows(Exception.class, ()-> ladderCreator.drawLine(3,Position.from(3)));

        // col값 미달
        Assertions.assertThrows(Exception.class, ()-> ladderCreator.drawLine(0,Position.from(-1)));
        Assertions.assertThrows(Exception.class, ()-> ladderCreator.drawLine(3,Position.from(-1)));

        // row값 초과
        Assertions.assertThrows(Exception.class, ()-> ladderCreator.drawLine(4,Position.from(0)));
        Assertions.assertThrows(Exception.class, ()-> ladderCreator.drawLine(4,Position.from(2)));

        // row값 미만
        Assertions.assertThrows(Exception.class, ()-> ladderCreator.drawLine(-1,Position.from(0)));
        Assertions.assertThrows(Exception.class, ()-> ladderCreator.drawLine(-1,Position.from(2)));
    }

    @Test
    @DisplayName("drawLine - invalid input -  already exist")
    public void drawLineDuplicated(){
        NormalLadderCreator ladderCreator = new NormalLadderCreator(GreaterThanOne.from(4), GreaterThanOne.from(4));
        ladderCreator.drawLine(0,Position.from(1));
        Assertions.assertThrows(Exception.class, ()-> ladderCreator.drawLine(0,Position.from(1)));
        Assertions.assertThrows(Exception.class, ()-> ladderCreator.drawLine(0,Position.from(2)));
    }
    
    @Test
    @DisplayName("run - no drawLine")
    public void runNoDrawline() {
        LadderGame ladder = new LadderGame(new NormalLadderCreator(GreaterThanOne.from(4),GreaterThanOne.from(4)));
        Assertions.assertEquals(0, ladder.run(Position.from(0)));
        Assertions.assertEquals(1, ladder.run(Position.from(1)));
        Assertions.assertEquals(2, ladder.run(Position.from(2)));
        Assertions.assertEquals(3, ladder.run(Position.from(3)));
    }

    @Test
    @DisplayName("run - with drawLine")
    public void runDrawline() {
        NormalLadderCreator ladderCreator = new NormalLadderCreator(GreaterThanOne.from(4), GreaterThanOne.from(4));
        LadderGame ladder = new LadderGame(ladderCreator);

        ladderCreator.drawLine(0,Position.from(0));
        ladderCreator.drawLine(0,Position.from(2));
        ladderCreator.drawLine(1,Position.from(1));
        ladderCreator.drawLine(2,Position.from(0));
        ladderCreator.drawLine(3,Position.from(1));

        Assertions.assertEquals(1, ladder.run(Position.from(0)));
        Assertions.assertEquals(2, ladder.run(Position.from(1)));
        Assertions.assertEquals(3, ladder.run(Position.from(2)));
        Assertions.assertEquals(0, ladder.run(Position.from(3)));
    }


}