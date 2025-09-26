import java.util.Random;

public final class LadderGameFactory {
    private LadderGameFactory() {
    }

    public static LadderGame create(LadderProvider provider) {
        return new LadderGame(provider);
    }

    public static LadderGame create(LadderProvider provider, LadderTraversalObserver observer) {
        return new LadderGame(provider, observer);
    }

    public static LadderGame createRandomLadderGame(int height, int numberOfPerson) {
        return createRandomLadderGame(height, numberOfPerson, new Random());
    }

    public static LadderGame createRandomLadderGame(int height, int numberOfPerson, Random random) {
        LadderProvider provider = new RandomLadderCreator(height, numberOfPerson, random);
        LadderTraversalObserver observer = new LadderConsolePrinter();
        return new LadderGame(provider, observer);
    }
}