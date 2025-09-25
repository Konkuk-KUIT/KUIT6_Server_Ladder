import creator.NormalLadderCreator;
import game.LadderGame;
import game.LadderGameFactory;
import game.LineNumberFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NaturalNumber;

class LadderTest {



    @Test
    public void 줄만들기() {
        //given
        NormalLadderCreator creator = new NormalLadderCreator(NaturalNumber.from(5), NaturalNumber.from(5));
        LadderGame ladderGame = new LadderGame(creator);
        LineNumberFactory numberFactory = creator.getNumberFactory();

        //when
        creator.drawLine(numberFactory.factory(0));
        creator.drawLine(numberFactory.factory(1));
        creator.drawLine(numberFactory.factory(2));
        creator.drawLine(numberFactory.factory(3));
        creator.drawLine(numberFactory.factory(4));

        //then
         creator.getBoard().printGrid();
    }



    @Test
    public void 줄만들고_출력하기() {
        //given
        NormalLadderCreator creator = new NormalLadderCreator(NaturalNumber.from(5), NaturalNumber.from(5));
        LadderGame ladderGame = new LadderGame(creator);
        LineNumberFactory numberFactory = creator.getNumberFactory();

        //when
        creator.drawLine(numberFactory.factory(2));
        creator.drawLine(numberFactory.factory(1));
        creator.drawLine(numberFactory.factory(0));
        creator.drawLine(numberFactory.factory(3));
        creator.drawLine(numberFactory.factory(4));

        //then
        ladderGame.run(numberFactory.factory(0));
    }

    @Test
    @DisplayName("일반적으로 생성할 때 인원수가 1명인 경우")
    public void 인원수_예외처리1() {
        //given
        NormalLadderCreator creator = new NormalLadderCreator(NaturalNumber.from(5), NaturalNumber.from(1));
        LadderGame ladderGame = new LadderGame(creator);
        LineNumberFactory numberFactory = creator.getNumberFactory();

        //when
        creator.drawLine(numberFactory.factory(0));


        //then
        ladderGame.run(numberFactory.factory(0));
    }

    @Test
    @DisplayName("일반적으로 생성할 때 높이가 1인 경우")
    public void 높이_예외처리1() {
        //given
        NormalLadderCreator creator = new NormalLadderCreator(NaturalNumber.from(1), NaturalNumber.from(5));
        LadderGame ladderGame = new LadderGame(creator);
        LineNumberFactory numberFactory = creator.getNumberFactory();

        //when
        creator.drawLine(numberFactory.factory(0));
        //then
        ladderGame.run(numberFactory.factory(0));
    }

    @Test
    @DisplayName("사다리 자동생성")
    void 사다리자동생성() throws Exception {
        //given
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(NaturalNumber.from(5), NaturalNumber.from(5));
        LineNumberFactory numberFactory = ladderGame.getNumberFactory();
        //when

        //then
        ladderGame.run(numberFactory.factory(0));

    }

    @Test
    @DisplayName("랜덤으로 생성할 때 높이가 1인 경우")
    void  높이_예외처리2() throws Exception {
        //given
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(NaturalNumber.from(1), NaturalNumber.from(5));
        LineNumberFactory numberFactory = ladderGame.getNumberFactory();
        //when

        //then
        ladderGame.run(numberFactory.factory(0));
    }

    @Test
    @DisplayName("랜덤으로 생성할 때 사람이 1명인 경우")
    void 인원수_예외처리2() throws Exception {
        //given
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(NaturalNumber.from(5), NaturalNumber.from(1));
        LineNumberFactory numberFactory = ladderGame.getNumberFactory();
        //when

        //then
        // 0 이 되어야 한다.
        ladderGame.run(numberFactory.factory(0));
    }
}