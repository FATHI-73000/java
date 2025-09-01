package game;

/**
 * Représente une case contenant une arme sur le plateau de jeu.
 * Lorsqu'un personnage arrive sur cette case, il peut récupérer l'arme.
 */
public class WeaponCell extends Cell {

    /**
     * Constructeur de la case arme.
     *
     * @param position Position de la case sur le plateau (commence à 1)
     */
    public WeaponCell(int position) {
        super(position);
    }

    /**
     * Retourne une description textuelle de la case.
     *
     * @return une chaîne décrivant la case arme
     */
    @Override
    public String toString() {
        return "Case " + position + " : Vous trouvez une arme puissante.";
    }
}
