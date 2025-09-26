public class LadderGameFactory {
    private LadderGameFactory() {}

    public static LadderGame createAutoLadderGame(LadderSize ladderSize) {
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(ladderSize);
        AutoLadderCreator autoLadderCreator = new AutoLadderCreator(manualLadderCreator);

        return new LadderGame(autoLadderCreator);
    }
    
    public static LadderGame createManualLadderGame(LadderSize ladderSize) {
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(ladderSize);
        return new LadderGame(manualLadderCreator);
    }

}
