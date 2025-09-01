package game;

/**
 * Classe abstraite représentant une case du plateau de jeu.
 */
public abstract class Cell {
    /** Position de la case sur le plateau */
    protected int position;

    /**
     * Crée une case à une position donnée.
     *
     * @param position La position de la case sur le plateau
     */
    public Cell(int position) {
        this.position = position;
    }

    /**
     * Retourne la position de la case.
     *
     * @return La position sur le plateau
     */
    public int getPosition() {
        return position;
    }

    /**
     * Retourne une représentation textuelle de la case.
     *
     * @return Une chaîne représentant la case
     */
    @Override
    public abstract String toString();
}
