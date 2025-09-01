package game;

/**
 * Représente une case vide sur le plateau de jeu.
 * Hérite de la classe {@link Cell} et implémente l'interface {@link ICell}.
 */
public class EmptyCell extends Cell implements ICell {

    /**
     * Crée une case vide à une position donnée.
     *
     * @param position La position de la case sur le plateau
     */
    public EmptyCell(int position) {
        super(position);
    }

    /**
     * Retourne une représentation textuelle de la case vide.
     * La méthode redéfinit {@link Cell#toString()}.
     *
     * @return Une chaîne indiquant que c'est une case vide et sa position
     */
    @Override
    public String toString() {
        return "Case " + position + " : Case vide";
    }
}
