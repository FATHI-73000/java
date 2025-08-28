package characters;

import equipment.OfensiveEquipement;
import equipment.DefensiveEquipement;
import exceptions.PersonnageHorsPlateauException;

public abstract class Character {
    private String name;
    private int health;
    private int attack;
    private OfensiveEquipement offensiveEquipment;
    private DefensiveEquipement defensiveEquipment;

    private int position;       // Position sur le plateau
    private int taillePlateau;  // Taille maximale du plateau

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

    // Méthode pour déplacer le personnage
    public void deplacer(int deplacement) throws PersonnageHorsPlateauException {
        int nouvellePosition = position + deplacement;
        if (nouvellePosition > taillePlateau) {
            throw new PersonnageHorsPlateauException(
                    name + " a dépassé la case finale (" + taillePlateau + ") !"
            );
        }
        position = nouvellePosition;
        System.out.println(name + " se déplace à la case " + position);
    }

    public int getPosition() { return position; }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttack() { return attack; }
    public OfensiveEquipement getOffensiveEquipment() { return offensiveEquipment; }
    public DefensiveEquipement getDefensiveEquipment() { return defensiveEquipment; }

    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
    public void setAttack(int attack) { this.attack = attack; }
    public void setOffensiveEquipment(OfensiveEquipement offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }
    public void setDefensiveEquipment(DefensiveEquipement defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    public abstract void presentation();

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
