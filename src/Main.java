import characters.Warrior;
import characters.Wizard;
import exceptions.PersonnageHorsPlateauException;
import game.Cell;
import game.Game;

public class Main {
    public static void main(String[] args) {

        int taillePlateau = 4; // Plateau fixe dans Game, taille = 4

        // --- 1. Présentation des personnages ---
        Warrior arthur = new Warrior("Arthur", taillePlateau);
        Wizard merlin = new Wizard("Merlin", taillePlateau);

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

        // --- 3. Tests de déplacement avec gestion d'exception ---

        System.out.println("\n--- Tests de déplacement avec exception ---");

        Warrior thor2 = new Warrior("Thor", taillePlateau);
        Wizard merlin2 = new Wizard("Merlin", taillePlateau);

        try {
            thor2.deplacer(3);
            thor2.deplacer(5); // Va au-delà de la limite → exception
        } catch (PersonnageHorsPlateauException e) {
            System.out.println("⚠️ Exception (Thor): " + e.getMessage());
        }

        try {
            merlin2.deplacer(2);
            merlin2.deplacer(6); // Va au-delà de la limite → exception
        } catch (PersonnageHorsPlateauException e) {
            System.out.println("⚠️ Exception (Merlin): " + e.getMessage());
        }

        System.out.println(thor2);
        System.out.println(merlin2);
    }
}
