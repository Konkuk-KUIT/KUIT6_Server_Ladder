public class LadderGame {
    private final LadderProvider ladderProvider;
    private final LadderTraversalObserver observer;

    public LadderGame(LadderProvider ladderProvider) {
        this(ladderProvider, LadderTraversalObserver.noop());
    }

    public LadderGame(LadderProvider ladderProvider, LadderTraversalObserver observer) {
        this.ladderProvider = ladderProvider;
        this.observer = observer;
    }

    public int run(int startPosition) {
        Ladder ladder = ladderProvider.provide();
        LadderRunner runner = new LadderRunner(ladder);
        return runner.run(startPosition, observer);
    }
}