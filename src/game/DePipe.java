package game;

// mot-clé "implements"
public class DePipe implements De {

    @Override
    public int lancer() {
        return 1; // toujours 1
    }

    @Override
    public int getFaces() {
        return 1;
    }
}
