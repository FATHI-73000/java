package characters;

import equipment.Sort;
import equipment.Philtre;

public class Wizard extends Character {

    public Wizard(String name, int taillePlateau) {
        super(name,
                70,
                40,
                new Sort("Boule de feu", 20),
                new Philtre("Potion de soin", 15),
                taillePlateau
        );
    }

    @Override
    public void presentation() {
        System.out.println(" Je suis le wizard " + getName() +
                " ! J'ai " + getHealth() + " PV et " + getAttack() + " ATQ.");
    }
}
