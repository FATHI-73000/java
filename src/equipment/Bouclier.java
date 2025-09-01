package equipment;

/**
 * Classe représentant un bouclier défensif.
 * Hérite de DefensiveEquipement et permet de définir le nom et la puissance de défense.
 */
public class Bouclier extends DefensiveEquipement {

    /**
     * Crée un bouclier défensif avec un nom et une puissance de défense.
     *
     * @param name Le nom du bouclier
     * @param defensePower La puissance de défense du bouclier
     */
    public Bouclier(String name, int defensePower) {
        super(name, defensePower);
    }
}
