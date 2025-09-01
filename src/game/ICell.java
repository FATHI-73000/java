package game;

/**
 * Interface représentant une case du plateau.
 * Toutes les cases doivent implémenter la méthode {@link #toString()}
 * pour fournir une description textuelle de la case.
 */
public interface ICell {

    /**
     * Retourne une description textuelle de la case.
     *
     * @return description de la case
     */
    @Override
    String toString();
}
