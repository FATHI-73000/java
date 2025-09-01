import characters.Character;
import characters.Warrior;
import characters.Wizard;
import exceptions.PersonnageHorsPlateauException;
import game.Cell;
import game.Game;

/**
 * Classe principale pour exécuter le jeu.
 * Présente les personnages et effectue un déplacement manuel sur le plateau.
 */
public class Main {

    /**
     * Point d'entrée de l'application.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {

        int taillePlateau = 4; // Plateau fixe dans Game, taille = 4

        // --- 1. Présentation des personnages ---
        Character arthur = new Warrior("Arthur", taillePlateau);
        Character merlin = new Wizard("Merlin", taillePlateau);

        // Affiche les présentations et informations
        arthur.presentation();
        merlin.presentation();

        System.out.println(arthur);
        System.out.println(merlin);

        // --- 2. Déplacement manuel sur plateau de 4 cases ---
        System.out.println("\n--- Début du jeu manuel avec Warrior (plateau de 4 cases) ---");

        Game game = new Game(); // Initialise le plateau
        Warrior thor = new Warrior("Thor", taillePlateau);

        System.out.println("Début du jeu avec le joueur : " + thor.getName());

        int position = 0; // Position de départ
        while (position < taillePlateau) {
            position++;  // avance d’une case
            Cell caseCourante = game.getPlateau().get(position - 1);
            System.out.println("Le joueur avance à la case " + position);
            System.out.println(caseCourante.toString());
            // Ici tu peux ajouter une interaction entre le joueur et la case
        }

        System.out.println("Le joueur " + thor.getName() + " a terminé le parcours !");
    }
}
