package equipment;

/**
 * Classe représentant un sort offensif.
 * Hérite de OfensiveEquipement et permet de définir le nom et la puissance d'attaque.
 */
public class Sort extends OfensiveEquipement {

    /**
     * Crée un sort avec un nom et une puissance d'attaque.
     *
     * @param name Le nom du sort
     * @param attackPower La puissance d'attaque du sort
     */
    public Sort(String name, int attackPower) {
        super(name, attackPower);
    }
}
