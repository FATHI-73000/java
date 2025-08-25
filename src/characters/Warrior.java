package characters;

import equipment.OfensiveEquipment;
import equipment.DefensiveEquipment;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name,
                100,    // vie
                30,     // attaque
                new OfensiveEquipment("Épée en acier", 15, "Weapon"),
                new DefensiveEquipment("Bouclier en bois", 10, "Shield"));
    }
}
