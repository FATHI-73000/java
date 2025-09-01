package characters;

import equipment.OfensiveEquipement;
import equipment.DefensiveEquipement;
import exceptions.PersonnageHorsPlateauException;

/**
 * Classe abstraite représentant un personnage du jeu.
 * Chaque personnage possède un nom, des points de vie, une force,
 * un équipement offensif et défensif, et une position sur le plateau.
 */
public abstract class Character {
    /** Nom du personnage */
    private String name;

    /** Points de vie du personnage */
    private int health;

    /** Force d’attaque du personnage */
    private int attack;

    /** Équipement offensif du personnage */
    private OfensiveEquipement offensiveEquipment;

    /** Équipement défensif du personnage */
    private DefensiveEquipement defensiveEquipment;

    /** Position actuelle du personnage sur le plateau */
    private int position;

    /** Taille maximale du plateau */
    private int taillePlateau;

    /**
     * Crée un nouveau personnage avec ses caractéristiques et équipements.
     *
     * @param name Nom du personnage
     * @param health Points de vie
     * @param attack Force d’attaque
     * @param offensiveEquipment Équipement offensif
     * @param defensiveEquipment Équipement défensif
     * @param taillePlateau Taille maximale du plateau de jeu
     */
    public Character(String name, int health, int attack,
                     OfensiveEquipement offensiveEquipment,
                     DefensiveEquipement defensiveEquipment,
                     int taillePlateau) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
        this.position = 0;           // départ à la case 0
        this.taillePlateau = taillePlateau;
    }

    /** @return la position actuelle du personnage */
    public int getPosition() { return position; }

    /** @return le nom du personnage */
    public String getName() { return name; }

    /** @return les points de vie du personnage */
    public int getHealth() { return health; }

    /** @return la force d’attaque du personnage */
    public int getAttack() { return attack; }

    /** @return l’équipement offensif du personnage */
    public OfensiveEquipement getOffensiveEquipment() { return offensiveEquipment; }

    /** @return l’équipement défensif du personnage */
    public DefensiveEquipement getDefensiveEquipment() { return defensiveEquipment; }

    /** @param name Nom à définir pour le personnage */
    public void setName(String name) { this.name = name; }

    /** @param health Points de vie à définir */
    public void setHealth(int health) { this.health = health; }

    /** @param attack Force à définir */
    public void setAttack(int attack) { this.attack = attack; }

    /** @param offensiveEquipment Équipement offensif à définir */
    public void setOffensiveEquipment(OfensiveEquipement offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }

    /** @param defensiveEquipment Équipement défensif à définir */
    public void setDefensiveEquipment(DefensiveEquipement defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    /** Affiche la présentation du personnage. Méthode abstraite à implémenter dans les sous-classes. */
    public abstract void presentation();

    /**
     * @return Une chaîne de caractères représentant le personnage et ses caractéristiques
     */
    @Override
    public String toString() {
        return "Personnage : " + name +
                ", Niveau de vie : " + health +
                ", Force : " + attack +
                ", Position : " + position +
                ", Équipement offensif : " + offensiveEquipment +
                ", Équipement défensif : " + defensiveEquipment;
    }
}
