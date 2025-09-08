
import game.Game;
import characters.Warrior;
import characters.Wizard;
import exceptions.PersonnageHorsPlateauException;


public class Main {
    public static void main(String[] args) {
        // Initialisation du jeu
        Game game = new Game(); // plateau de taille 10

        // Lancement du jeu
        game.start();
    }
}
