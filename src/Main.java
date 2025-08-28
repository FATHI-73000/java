import characters.Warrior;
import game.Cell;
import game.Game;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();  // Création du jeu (initialise le plateau)

        // Création manuelle d’un personnage Warrior (tu peux modifier)
        Warrior joueur = new Warrior("Thor", 4); // taille du plateau = 4

        System.out.println("Début du jeu avec le joueur : " + joueur.getName());

        int position = 0;

        // Le joueur avance case par case sur le plateau
        while (position < 4) {
            position++;  // avance d’une case

            // Récupère la case courante
            Cell caseCourante = game.getPlateau().get(position - 1);

            System.out.println("Le joueur avance à la case " + position);
            System.out.println(caseCourante.toString());

            // Ici tu peux ajouter l’interaction entre joueur et case si besoin
        }

        System.out.println("Le joueur " + joueur.getName() + " a terminé le parcours !");
    }
}

