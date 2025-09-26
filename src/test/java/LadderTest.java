//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class LadderTest {
//    LadderCreator ladderCreator = new LadderCreator(7, 7);
//
//    @BeforeEach
//    void setUp() {
//        ladderCreator.drawLine(new Position(0, 0));
//        ladderCreator.drawLine(new Position(1, 1));
//        ladderCreator.drawLine(new Position(2, 5));
//        ladderCreator.drawLine(new Position(5, 2));
//    }
//
//
//    @Test
//    @DisplayName("사다리 게임 정상 작동 테스트")
//    void testGame() {
//        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
//        assertEquals(2, ladderRunner.run(1));
//    }


//    @DisplayName("테스트 정상 작동 테스트")
//    @ParameterizedTest(name = "start={0} → expected={1}")
//    @CsvSource({
//            "0, 3",
//            "1, 2",
//            "5, 6",
//            "3, 3"
//    })
//    void runParameterized(int start, int expected) {
//        ladderRunner = new LadderRunner(ladderCreator.getRows());
//        assertEquals(expected, ladderRunner.run(start));
//    }
//}
