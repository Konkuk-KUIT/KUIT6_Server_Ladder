public class main {
    public static void main(String[] args) {
        // 팩토리 메서드를 통해 참가자 5명, 높이 7의 무작위 사다리 게임 생성
        LadderGame game = LadderGameFactory.createRandomLadderGame(5, 7);

        // 2번 참가자로 게임 실행 및 과정 출력
        game.runAndPrint(2);
    }
}