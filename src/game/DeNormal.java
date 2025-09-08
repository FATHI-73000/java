package game;

import java.util.Random;

// mot-clé "implements"
public class DeNormal implements De {
    private Random random = new Random();

    @Override
    public int lancer() {
        return random.nextInt(6) + 1; // de 1 à 6
    }

    @Override
    public int getFaces() {
        return 6;
    }
}
