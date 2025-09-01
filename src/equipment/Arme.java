package equipment;

/**
 * Classe représentant une arme offensive.
 * Hérite de OfensiveEquipement et permet de définir le nom et la puissance d'attaque.
 */
public class Arme extends OfensiveEquipement {

    /**
     * Crée une arme offensive avec un nom et une puissance d'attaque.
     *
     * @param name Le nom de l'arme
     * @param attackPower La puissance d'attaque de l'arme
     */
    public Arme(String name, int attackPower) {
        super(name, attackPower);
    }
}
