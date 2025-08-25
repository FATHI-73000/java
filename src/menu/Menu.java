package menu;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.util.Scanner;

public class Menu {
    // Scanner utilisé pour lire les entrées utilisateur
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Affiche le menu principal avec les options disponibles
     */
    public void afficherMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Créer un personnage");
        System.out.println("2. Quitter");
        System.out.print("Votre choix : ");
    }

    /**
     * Affiche le sous-menu une fois un personnage créé
     */
    public void afficherSousMenuPersonnage() {
        System.out.println("\n=== MENU PERSONNAGE ===");
        System.out.println("1. Afficher les infos du personnage");
        System.out.println("2. Modifier le personnage");
        System.out.println("3. Démarrer la partie");
        System.out.println("4. Quitter");
        System.out.print("Votre choix : ");
    }

    /**
     * Lit un choix utilisateur sous forme d'entier
     * Gère les entrées invalides jusqu'à ce qu'un entier soit saisi
     * @return l'entier saisi par l'utilisateur
     */
    public int lireChoixUtilisateur() {
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un nombre valide : ");
            scanner.next();  // consomme l'entrée incorrecte
        }
        return scanner.nextInt();
    }

    /**
     * Crée un personnage en fonction du choix de l'utilisateur
     * @return un objet Character créé (Warrior ou Wizard), ou null si choix invalide
     */
    public Character creerPersonnage() {
        System.out.println("Quel type de personnage voulez-vous créer ?");
        System.out.println("1. Guerrier");
        System.out.println("2. Magicien");

        int choix = lireChoixUtilisateur();
        scanner.nextLine(); // consomme le saut de ligne restant

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

    /**
     * Ferme le scanner pour libérer les ressources
     */
    public void fermerScanner() {
        scanner.close();
    }
}
