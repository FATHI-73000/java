package menu;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void afficherMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Créer un personnage");
        System.out.println("2. Quitter");
        System.out.print("Votre choix : ");
    }

    public void afficherSousMenuPersonnage() {
        System.out.println("\n=== MENU PERSONNAGE ===");
        System.out.println("1. Afficher les infos du personnage");
        System.out.println("2. Modifier le personnage");
        System.out.println("3. Démarrer la partie");
        System.out.println("4. Quitter");
        System.out.print("Votre choix : ");
    }

    public int lireChoixUtilisateur() {
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un nombre valide : ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public Character creerPersonnage() {
        System.out.println("Quel type de personnage voulez-vous créer ?");
        System.out.println("1. Guerrier");
        System.out.println("2. Magicien");

        int choix = lireChoixUtilisateur();
        scanner.nextLine(); // consommer le retour chariot

        System.out.print("Entrez le nom du personnage : ");
        String nom = scanner.nextLine();

        switch (choix) {
            case 1:
                return new Warrior(nom);
            case 2:
                return new Wizard(nom);
            default:
                System.out.println("Choix invalide. Création annulée.");
                return null;
        }
    }

    public void fermerScanner() {
        scanner.close();
    }
}
