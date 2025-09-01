package menu;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.util.Scanner;

/**
 * Classe représentant le menu du jeu.
 * Permet à l'utilisateur de créer et gérer un personnage,
 * puis de démarrer la partie.
 */
public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private static final int TAILLE_PLATEAU_PAR_DEFAUT = 10;

    /**
     * Affiche le menu principal avec les options disponibles.
     */
    public void afficherMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Créer un personnage");
        System.out.println("2. Quitter");
        System.out.print("Votre choix : ");
    }

    /**
     * Affiche le sous-menu après la création d'un personnage.
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
     * Lit un choix utilisateur et s'assure qu'il s'agit d'un entier valide.
     *
     * @return le choix de l'utilisateur sous forme d'entier
     */
    public int lireChoixUtilisateur() {
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un nombre valide : ");
            scanner.next(); // consomme l'entrée incorrecte
        }
        int choix = scanner.nextInt();
        scanner.nextLine(); // consomme le saut de ligne restant
        return choix;
    }

    /**
     * Crée un personnage en fonction du choix de l'utilisateur.
     *
     * @return le personnage créé ou null si la création est annulée
     */
    public Character creerPersonnage() {
        System.out.println("Quel type de personnage voulez-vous créer ?");
        System.out.println("1. Guerrier");
        System.out.println("2. Magicien");

        int choix = lireChoixUtilisateur();

        System.out.print("Entrez le nom du personnage : ");
        String nom = scanner.nextLine();

        switch (choix) {
            case 1:
                return new Warrior(nom, TAILLE_PLATEAU_PAR_DEFAUT);
            case 2:
                return new Wizard(nom, TAILLE_PLATEAU_PAR_DEFAUT);
            default:
                System.out.println("Choix invalide. Création annulée.");
                return null;
        }
    }

    /**
     * Ferme le scanner utilisé pour lire les entrées utilisateur.
     */
    public void fermerScanner() {
        scanner.close();
    }
}
