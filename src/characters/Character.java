package characters;

import equipment.OfensiveEquipment;
import equipment.DefensiveEquipment;

public abstract class Character {
    // ✅ Attributs privés
    private String name;
    private int health;
    private int attack;
    private OfensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;

    // ✅ Constructeur principal (avec équipements)
    public Character(String name, int health, int attack,
                     OfensiveEquipment offensiveEquipment,
                     DefensiveEquipment defensiveEquipment) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

    // ✅ Constructeur secondaire (sans équipements)
    public Character(String name, int health, int attack) {
        this(name, health, attack, null, null);
    }

    // ✅ Getters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttack() { return attack; }
    public OfensiveEquipment getOffensiveEquipment() { return offensiveEquipment; }
    public DefensiveEquipment getDefensiveEquipment() { return defensiveEquipment; }

    // ✅ Setters
    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
    public void setAttack(int attack) { this.attack = attack; }
    public void setOffensiveEquipment(OfensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }
    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    // ✅ toString() personnalisé
    @Override
    public String toString() {
        return "Nom : " + name +
                " | Vie : " + health +
                " | Attaque : " + attack +
                " | Équipement offensif : " + offensiveEquipment +
                " | Équipement défensif : " + defensiveEquipment;
    }
}
