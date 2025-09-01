package equipment;

/**
 * Classe abstraite représentant un équipement offensif.
 * Contient un nom et une puissance d'attaque.
 */
public abstract class OfensiveEquipement {

    /** Nom de l'équipement offensif */
    protected String name;

    /** Puissance d'attaque de l'équipement */
    protected int attackPower;

    /**
     * Crée un équipement offensif avec un nom et une puissance d'attaque.
     *
     * @param name Le nom de l'équipement
     * @param attackPower La puissance d'attaque de l'équipement
     */
    public OfensiveEquipement(String name, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    /**
     * Retourne le nom de l'équipement offensif.
     *
     * @return le nom de l'équipement
     */
    public String getName() { return name; }

    /**
     * Retourne la puissance d'attaque de l'équipement.
     *
     * @return la puissance d'attaque
     */
    public int getAttackPower() { return attackPower; }

    /**
     * Définit le nom de l'équipement.
     *
     * @param name Nouveau nom de l'équipement
     */
    public void setName(String name) { this.name = name; }

    /**
     * Définit la puissance d'attaque de l'équipement.
     *
     * @param attackPower Nouvelle puissance d'attaque
     */
    public void setAttackPower(int attackPower) { this.attackPower = attackPower; }

    /**
     * Retourne une représentation textuelle de l'équipement.
     *
     * @return chaîne décrivant le nom et la puissance d'attaque
     */
    @Override
    public String toString() {
        return name + " (attaque : " + attackPower + ")";
    }
}

