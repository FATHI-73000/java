package characters;

import equipment.Arme;
import equipment.Bouclier;

public class Warrior extends Character {

    public Warrior(String name, int taillePlateau) {
        super(name,
                100,
                30,
                new Arme("Épée en acier", 15),
                new Bouclier("Bouclier en bois", 10),
                taillePlateau
        );
    }

    @Override
    public void presentation() {
        System.out.println(" Je suis le warrior " + getName() +
                " ! J'ai " + getHealth() + " PV et " + getAttack() + " ATQ.");
    }
}
