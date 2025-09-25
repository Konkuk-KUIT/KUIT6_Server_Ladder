package game;

import creator.NormalLadderCreator;
import creator.RandomLadderCreator;
import util.NaturalNumber;

public class LadderGameFactory {

    public static LadderGame createNormalLadderGame(NaturalNumber row, NaturalNumber numberOfPerson) {
        NormalLadderCreator creator = new NormalLadderCreator(row, numberOfPerson);
        return new  LadderGame(creator);
    }
    public static LadderGame createRandomLadderGame(NaturalNumber row, NaturalNumber numberOfPerson) {
        RandomLadderCreator creator = new RandomLadderCreator(row, numberOfPerson);
        return new  LadderGame(creator);
    }
}
