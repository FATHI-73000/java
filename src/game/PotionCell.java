package game;

/**
 * Représente une case contenant une potion sur le plateau de jeu.
 * Lorsqu'un personnage arrive sur cette case, il peut récupérer la potion.
 */
public class PotionCell extends Cell {

    /**
     * Constructeur de la case potion.
     *
     * @param position Position de la case sur le plateau (commence à 1)
     */
    public PotionCell(int position) {
        super(position);
    }

    /**
     * Retourne une description textuelle de la case.
     *
     * @return une chaîne décrivant la case potion
     */
    @Override
    public String toString() {
        return "Case " + position + " : Une potion magique est là.";
    }
}
