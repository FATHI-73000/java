package characters;

import equipment.OfensiveEquipement;
import equipment.DefensiveEquipement;
import equipment.Arme;
import equipment.Bouclier;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name,
                100, // vie
                30,  // attaque
                new Arme("Épée en acier", 15),        // équipement offensif concret
                new Bouclier("Bouclier en bois", 10) // équipement défensif concret
        );
    }

    @Override
    public void presentation() {
        System.out.println("⚔️ Je suis le warrior " + getName() +
                " ! J'ai " + getHealth() + " PV et " + getAttack() + " ATQ.");
    }
}
