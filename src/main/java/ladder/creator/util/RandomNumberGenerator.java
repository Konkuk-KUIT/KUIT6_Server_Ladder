package ladder.creator.util;

public class RandomNumberGenerator implements NumberGenerator{


    @Override
    public int getNumber(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
