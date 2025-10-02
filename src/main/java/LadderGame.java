import java.util.Objects;

public class LadderGame {
    private final LadderProvider ladderProvider;
    private final LadderTraversalObserver observer;

//    public LadderGame(LadderProvider ladderProvider) {
//        this(ladderProvider, LadderTraversalObserver.noop());
//    }

    public LadderGame(LadderProvider ladderProvider) {
        this(Objects.requireNonNull(ladderProvider, "ladderProvider"), LadderTraversalObserver.noop());
    }

//    public LadderGame(LadderProvider ladderProvider, LadderTraversalObserver observer) {
//        this.ladderProvider = ladderProvider;
//        this.observer = observer;
//    }

    public LadderGame(LadderProvider ladderProvider, LadderTraversalObserver observer) {
        this.ladderProvider = Objects.requireNonNull(ladderProvider, "ladderProvider");
        this.observer = Objects.requireNonNull(observer, "observer");
    }

    public int run(int startPosition) {
        // Ladder ladder = ladderProvider.provide();
        Ladder ladder = Objects.requireNonNull(ladderProvider.provide(), "provider.provide() returned null");
        LadderRunner runner = new LadderRunner(ladder);
        return runner.run(startPosition, observer);
    }
}