public class LadderGameFactory {

    // 구현사항 3: 정적 팩토리 메서드 사용
    public static NaturalNumber playRandomLadderGame(NaturalNumber height, NaturalNumber numberOfPeople, NaturalNumber startPosition) {
        LadderCreator creator = new RandomLadderCreator();
        Ladder ladder = creator.createLadder(height, numberOfPeople);

        LadderGame game = new LadderGame();
        return game.runGame(ladder, startPosition);
    }
}
