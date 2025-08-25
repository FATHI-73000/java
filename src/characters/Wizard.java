package characters;

import equipment.OfensiveEquipment;
import equipment.DefensiveEquipment;

public class Wizard extends Character {

    public Wizard(String name) {
        super(name,
                70,     // vie
                40,     // attaque
                new OfensiveEquipment("Boule de feu", 20, "Spell"),
                new DefensiveEquipment("Potion de soin", 15, "Potion"));
    }
}
