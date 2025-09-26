public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(int rowSize, int numberOfPerson) {
        LadderCreator randomCreator = new RandomLadderCreator();
        randomCreator.create(rowSize, numberOfPerson);
        randomCreator.drawLine(new Position(0,0));
        return new LadderGame(randomCreator);
    }

    public static LadderGame createDefaultLadderGame(int rowSize, int numberOfPerson) {
        LadderCreator defaultCreator = new DefaultLadderCreator();
        //Todo: 근데 LadderGame 에서 run에서도 이걸 create로 생성해주던데 뭐지
        defaultCreator.create(rowSize, numberOfPerson);
        return new LadderGame(defaultCreator);
    }
}
