package characters;

import equipment.Arme;
import equipment.Bouclier;

/**
 * Classe représentant un personnage de type Warrior.
 * Le Warrior a des points de vie et une force d'attaque fixes,
 * ainsi qu'un équipement offensif (épée) et défensif (bouclier) par défaut.
 */
public class Warrior extends Character {

    /**
     * Crée un Warrior avec un nom donné et une taille de plateau.
     *
     * @param name Le nom du Warrior
     * @param taillePlateau La taille maximale du plateau sur lequel le Warrior peut se déplacer
     */
    public Warrior(String name, int taillePlateau) {
        super(name,
                100,  // points de vie
                30,   // force d'attaque
                new Arme("Épée en acier", 15),
                new Bouclier("Bouclier en bois", 10),
                taillePlateau
        );
    }

    /**
     * Affiche la présentation du Warrior.
     * Montre le nom, les points de vie et la force d'attaque.
     */
    @Override
    public void presentation() {
        System.out.println("Je suis le warrior " + getName() +
                " ! J'ai " + getHealth() + " PV et " + getAttack() + " ATQ.");
    }
}
