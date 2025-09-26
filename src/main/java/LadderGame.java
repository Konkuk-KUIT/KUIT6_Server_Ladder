public class LadderGame {
    //private final LadderCreator ladderCreator;
    private final LadderProvider ladderProvider;
    // 인터페이스를 활용한 의존성 주입(DI)
//    LadderGame이 구체적인 LadderCreator가 아닌, 추상적인 인터페이스(Interface)에 의존하도록 변경할 수 있다.
//    이것이 바로 의존성 역전 원칙(DIP)


    public LadderGame(LadderProvider ladderProvider) {
        this.ladderProvider = ladderProvider;
    }

    public int run(int startX) {
        // 1. 사다리의 생성을 요청
        Row[] rows = ladderProvider.getRows();

        // 2. runner 에게 완성된 사다리를 건네준다.
        LadderRunner ladderRunner = new LadderRunner(rows);

        // 3. runner 에게 사다리를 타라고 메세지를 보낸다.
        return ladderRunner.run(startX);
    }
}
