package characters;

import equipment.OfensiveEquipement;
import equipment.DefensiveEquipement;

public abstract class Character {
    private String name;
    private int health;
    private int attack;
    private OfensiveEquipement offensiveEquipment;
    private DefensiveEquipement defensiveEquipment;

    public Character(String name, int health, int attack,
                     OfensiveEquipement offensiveEquipment,
                     DefensiveEquipement defensiveEquipment) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

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
                ", Équipement offensif : " + offensiveEquipment +
                ", Équipement défensif : " + defensiveEquipment;
    }
}
