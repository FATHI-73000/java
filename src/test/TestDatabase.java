package test;

import db.DatabaseManager;
import model.Character;

import java.util.List;

public class TestDatabase {
    public static void main(String[] args) {
        System.out.println("Liste des héros dans la base :");
        List<Character> heroes = DatabaseManager.getHeroes();
        for (Character hero : heroes) {
            System.out.println(hero);
        }

        System.out.println("\nCréation d’un nouveau héros...");
        Character newHero = new Character("Guerrier", "Aragorn", 100, 20, "Épée", "Bouclier");
        boolean created = DatabaseManager.createHero(newHero);
        System.out.println("Création réussie ? " + created);

        System.out.println("\nListe mise à jour :");
        heroes = DatabaseManager.getHeroes();
        for (Character hero : heroes) {
            System.out.println(hero);
        }

        if (!heroes.isEmpty()) {
            // Modifier un héros (exemple)
            Character firstHero = heroes.get(0);
            firstHero.setLifePoints(firstHero.getLifePoints() - 10);
            boolean updated = DatabaseManager.changeLifePoints(firstHero);
            System.out.println("\nMise à jour des points de vie réussie ? " + updated);

            System.out.println("\nHéros après mise à jour des points de vie :");
            heroes = DatabaseManager.getHeroes();
            for (Character hero : heroes) {
                System.out.println(hero);
            }
        }
    }
}
