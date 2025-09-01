package game;

/**
 * Représente une case contenant un ennemi sur le plateau de jeu.
 * Hérite de la classe {@link Cell}.
 */
public class EnemyCell extends Cell {

    /**
     * Crée une case avec un ennemi à la position spécifiée.
     *
     * @param position La position de la case sur le plateau
     */
    public EnemyCell(int position) {
        super(position);
    }

    /**
     * Retourne une représentation textuelle de la case avec un ennemi.
     * Redéfinit {@link Cell#toString()}.
     *
     * @return Une chaîne indiquant qu'un ennemi se trouve sur cette case
     */
    @Override
    public String toString() {
        return "Case " + position + " : Un ennemi dangereux vous attend !";
    }
}
