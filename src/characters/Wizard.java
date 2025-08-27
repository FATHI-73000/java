package characters;

import equipment.OfensiveEquipement;
import equipment.DefensiveEquipement;
import equipment.Sort;
import equipment.Philtre;

public class Wizard extends Character {

    public Wizard(String name) {
        super(name,
                70,  // vie
                40,  // attaque
                new Sort("Boule de feu", 20),
                new Philtre("Potion de soin", 15));
    }

    @Override
    public void presentation() {
        System.out.println("✨ Je suis le wizard " + getName() +
                " ! J'ai " + getHealth() + " PV et " + getAttack() + " ATQ.");
    }
}
