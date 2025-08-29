import characters.Character;
import characters.Warrior;
import characters.Wizard;
import exceptions.PersonnageHorsPlateauException;
import game.Cell;
import game.Game;

public class Main {
    public static void main(String[] args) {

        int taillePlateau = 4; // Plateau fixe dans Game, taille = 4

        // --- 1. Présentation des personnages ---
        Character arthur = new Warrior("Arthur", taillePlateau);
        Character merlin = new Wizard("Merlin", taillePlateau);

        arthur.presentation();
        merlin.presentation();

        System.out.println(arthur);
        System.out.println(merlin);

        // --- 2. Déplacement manuel sur plateau 4 cases ---

        System.out.println("\n--- Début du jeu manuel avec Warrior (plateau de 4 cases) ---");

        Game game = new Game(); // Constructeur sans argument
        Warrior thor = new Warrior("Thor", taillePlateau);

        System.out.println("Début du jeu avec le joueur : " + thor.getName());

        int position = 0;
        while (position < taillePlateau) {
            position++;  // avance d’une case
            Cell caseCourante = game.getPlateau().get(position - 1);
            System.out.println("Le joueur avance à la case " + position);
            System.out.println(caseCourante.toString());
            // Ici tu peux ajouter une interaction entre joueur et case
        }

        System.out.println("Le joueur " + thor.getName() + " a terminé le parcours !");
    } // 👈 cette accolade manquait !
}
