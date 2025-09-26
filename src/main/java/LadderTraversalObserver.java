public interface LadderTraversalObserver {
    void beforeStep(int rowIndex, int currentPosition, Ladder ladder);

    void afterStep(int rowIndex, int currentPosition, Ladder ladder);

    static LadderTraversalObserver noop() {
        return new LadderTraversalObserver() {
            @Override
            public void beforeStep(int rowIndex, int currentPosition, Ladder ladder) {
                // no-op
            }

            @Override
            public void afterStep(int rowIndex, int currentPosition, Ladder ladder) {
                // no-op
            }
        };
    }
}