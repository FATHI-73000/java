package menu;

// ✅ Importation des classes nécessaires
import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.util.Scanner;

public class Menu {

    // ✅ Attribut privé : encapsulation respectée
    private final Scanner scanner = new Scanner(System.in);

    // ✅ Affiche le menu principal avec les options de départ
    public void afficherMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Créer un personnage");
        System.out.println("2. Quitter");
        System.out.print("Votre choix : ");
    }

    // ✅ Affiche le menu secondaire pour gérer un personnage
    public void afficherSousMenuPersonnage() {
        System.out.println("\n=== MENU PERSONNAGE ===");
        System.out.println("1. Afficher les infos du personnage");
        System.out.println("2. Modifier le personnage");
        System.out.println("3. Démarrer la partie");
        System.out.println("4. Quitter");
        System.out.print("Votre choix : ");
    }

    // ✅ Lit et valide un choix numérique de l’utilisateur
    public int lireChoixUtilisateur() {
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un nombre valide : ");
            scanner.next(); // Consomme la mauvaise entrée
        }
        return scanner.nextInt();
    }

    // ✅ Crée un personnage en demandant à l’utilisateur un type et un nom
    public Character creerPersonnage() {
        System.out.println("Quel type de personnage voulez-vous créer ?");
        System.out.println("1. Guerrier");
        System.out.println("2. Magicien");

        int choix = lireChoixUtilisateur();
        scanner.nextLine(); // Consomme le retour chariot (\n)

        System.out.print("Entrez le nom du personnage : ");
        String nom = scanner.nextLine();

        // ✅ Instanciation d’un objet selon le choix de l’utilisateur
        switch (choix) {
            case 1:
                return new Warrior(nom); // Appelle le constructeur de Warrior
            case 2:
                return new Wizard(nom);  // Appelle le constructeur de Wizard
            default:
                System.out.println("Choix invalide. Création annulée.");
                return null;
        }
    }

    // ✅ Ferme le Scanner proprement à la fin du programme
    public void fermerScanner() {
        scanner.close();
    }
}
