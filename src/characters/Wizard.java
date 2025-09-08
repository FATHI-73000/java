package characters;

import equipment.Sort;
import equipment.Philtre;
import com.google.gson.Gson;

/**
 * Classe représentant un personnage de type Wizard.
 * Le Wizard a des points de vie et une force d'attaque spécifiques,
 * ainsi qu'un équipement offensif (sort) et défensif (philtre) par défaut.
 */
public class Wizard extends Character {

    /**
     * Crée un Wizard avec un nom donné et une taille de plateau.
     *
     * @param name Le nom du Wizard
     * @param taillePlateau La taille maximale du plateau sur lequel le Wizard peut se déplacer
     */
    public Wizard(String name, int taillePlateau) {
        super(name,
                70,  // points de vie
                40,  // force d'attaque
                new Sort("Boule de feu", 20),
                new Philtre("Potion de soin", 15),
                taillePlateau
        );
    }

    /**
     * Affiche la présentation du Wizard.
     * Montre le nom, les points de vie et la force d'attaque.
     */
    @Override
    public void presentation() {
        System.out.println("Je suis le wizard " + getName() +
                " ! J'ai " + getHealth() + " PV et " + getAttack() + " ATQ.");
    }

    /**
     * Retourne une représentation JSON du Wizard.
     *
     * @return String JSON
     */
    @Override
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
