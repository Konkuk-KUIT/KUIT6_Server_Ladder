package printer;

import creator.RandomLadderCreator;
import domain.Ladder;
import domain.LadderSize;
import domain.NaturalNumber;
import domain.Position;
import game.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import printer.LadderPrinter;

@DisplayName("printer.LadderPrinter 디버깅 테스트")
class LadderPrinterTest {

    @Test
    @DisplayName("랜덤 사다리 구조와 참가자 이동 과정을 출력한다")
    void printLadderAndMovements() {
        // Given
        LadderSize size = new LadderSize(5, 4);
        RandomLadderCreator creator = new RandomLadderCreator(size);
        Ladder ladder = new Ladder(size, creator.getRows());
        LadderGame game = new LadderGame(ladder);
        LadderPrinter printer = new LadderPrinter(ladder);

        //When: 사다리 전체 출력
        System.out.println("=== 생성된 사다리 구조 ===");
        printer.printLadder();

        //Then: 각 참가자 이동 경로 출력
        System.out.println("\n=== 참가자 이동 시뮬레이션 ===");
        for (int i = 1; i <= ladder.getNumberOfPersons().value(); i++) {
            Position start = new Position(new NaturalNumber(i), ladder.getNumberOfPersons());
            System.out.println("\n참가자 " + i + " 출발");
            printer.printMovement(start);

            //최종 위치 확인
            System.out.println("최종 도착 위치 = " + game.play(new NaturalNumber(i)).value());
        }
    }
}
