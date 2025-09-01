package equipment;

/**
 * Classe représentant un philtre défensif.
 * Hérite de DefensiveEquipement et permet de définir le nom et la puissance de défense.
 */
public class Philtre extends DefensiveEquipement {

    /**
     * Crée un philtre avec un nom et une puissance de défense.
     *
     * @param name Le nom du philtre
     * @param defensePower La puissance de défense du philtre
     */
    public Philtre(String name, int defensePower) {
        super(name, defensePower);
    }
}
