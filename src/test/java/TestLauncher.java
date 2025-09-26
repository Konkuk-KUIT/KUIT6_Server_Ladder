public class TestLauncher {
    public static void main(String[] args) {
        runTest(new LadderCreatorTest());
        runTest(new LadderRunnerTest());
        runTest(new LadderGameTest());
        runTest(new LadderConsolePrinterTest());
        runTest(new RandomLadderCreatorTest());
        System.out.println("All tests passed");
    }

    private static void runTest(Object testInstance) {
        try {
            testInstance.getClass().getMethod("run").invoke(testInstance);
        } catch (ReflectiveOperationException e) {
            throw new AssertionError("Failed to execute tests for " + testInstance.getClass().getSimpleName(), e);
        }
    }
}