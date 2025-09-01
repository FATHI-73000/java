package equipment;

/**
 * Classe abstraite représentant un équipement défensif.
 * Contient un nom et une puissance de défense.
 */
public abstract class DefensiveEquipement {

    /** Nom de l'équipement défensif */
    protected String name;

    /** Puissance de défense de l'équipement */
    protected int defensePower;

    /**
     * Crée un équipement défensif avec un nom et une puissance de défense.
     *
     * @param name Le nom de l'équipement
     * @param defensePower La puissance de défense de l'équipement
     */
    public DefensiveEquipement(String name, int defensePower) {
        this.name = name;
        this.defensePower = defensePower;
    }

    /**
     * Retourne le nom de l'équipement défensif.
     *
     * @return le nom de l'équipement
     */
    public String getName() { return name; }

    /**
     * Retourne la puissance de défense de l'équipement.
     *
     * @return la puissance de défense
     */
    public int getDefensePower() { return defensePower; }

    /**
     * Définit le nom de l'équipement.
     *
     * @param name Nouveau nom de l'équipement
     */
    public void setName(String name) { this.name = name; }

    /**
     * Définit la puissance de défense de l'équipement.
     *
     * @param defensePower Nouvelle puissance de défense
     */
    public void setDefensePower(int defensePower) { this.defensePower = defensePower; }

    /**
     * Retourne une représentation textuelle de l'équipement.
     *
     * @return chaîne décrivant le nom et la puissance de défense
     */
    @Override
    public String toString() {
        return name + " (Défense : " + defensePower + ")";
    }
}
