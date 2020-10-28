package manager;

import java.util.Random;

public class RandomManager {
    private Random random;

    public RandomManager() {
        this.random = new Random();
    }

    public boolean getBooleanRandom() {
        return random.nextBoolean();
    }

    public int getIntRandom(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
