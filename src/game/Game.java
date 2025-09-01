package game;

import characters.Character;
import menu.Menu;
import exceptions.PersonnageHorsPlateauException;

import java.util.ArrayList;

/**
 * Classe représentant le jeu principal.
 * Gère le plateau, le joueur et la logique de déplacement.
 */
public class Game {

    private Character joueur;
    private ArrayList<Cell> board;        // plateau de jeu
    private int playerPosition = 0;       // position du joueur sur le plateau
    private int taillePlateau = 4;        // nombre de cases du plateau

    /**
     * Constructeur. Initialise le plateau de jeu.
     */
    public Game() {
        initialiserPlateau();
    }

    /**
     * Initialise le plateau avec 4 cases : vide, ennemi, arme, potion.
     */
    private void initialiserPlateau() {
        board = new ArrayList<>();
        board.add(new EmptyCell(1));
        board.add(new EnemyCell(2));
        board.add(new WeaponCell(3));
        board.add(new PotionCell(4));
    }

    /**
     * Retourne le plateau du jeu.
     */
    public ArrayList<Cell> getBoard() {
        return board;
    }

    /**
     * Lance un dé pipé pour avancer de 1 case.
     */
    private int lanceDe() {
        return 1;
    }

    /**
     * Démarre le jeu et gère le menu principal.
     */
    public void start() {
        Menu menu = new Menu();

        menu.afficherMenuPrincipal();
        int choix = menu.lireChoixUtilisateur();

        if (choix == 1) {
            joueur = menu.creerPersonnage();

            if (joueur == null) {
                System.out.println("Personnage non créé. Fin du jeu.");
                menu.fermerScanner();
                return;
            }

            System.out.println("Personnage créé : " + joueur);

            boolean enJeu = true;
            while (enJeu) {
                menu.afficherSousMenuPersonnage();
                int sousChoix = menu.lireChoixUtilisateur();

                switch (sousChoix) {
                    case 1 -> System.out.println(joueur);
                    case 2 -> {
                        Character nouveau = menu.creerPersonnage();
                        if (nouveau != null) {
                            joueur = nouveau;
                            System.out.println("Nouveau personnage : " + joueur);
                        } else {
                            System.out.println("Personnage non modifié.");
                        }
                    }
                    case 3 -> jouer();  // lance la boucle principale
                    case 4 -> {
                        System.out.println("Merci d'avoir joué !");
                        enJeu = false;
                    }
                    default -> System.out.println("Choix invalide.");
                }
            }
        } else if (choix == 2) {
            System.out.println("À bientôt !");
        } else {
            System.out.println("Choix invalide.");
        }

        menu.fermerScanner();
    }

    /**
     * Méthode principale pour jouer tout le plateau.
     */
    private void jouer() {
        System.out.println("Début de la partie !");
        playerPosition = 0;

        while (playerPosition < taillePlateau) {
            playTurn();
        }

        System.out.println("Bravo " + joueur.getName() + ", tu as terminé le donjon !");
    }

    /**
     * Gère un tour complet : lancer le dé, avancer, interaction avec la case.
     */
    private void playTurn() {
        int de = lanceDe();
        try {
            deplacer(de);
        } catch (PersonnageHorsPlateauException e) {
            System.out.println("Erreur : " + e.getMessage());
            playerPosition = taillePlateau; // fin du jeu
            return;
        }

        Cell caseActuelle = board.get(playerPosition);
        System.out.println(joueur.getName() + " avance de " + de + " case(s) et arrive à la case " + (playerPosition + 1));
        System.out.println(caseActuelle);

        // Ici, tu peux ajouter des interactions selon le type de case
        // ex : caseActuelle.interagir(joueur);
    }

    /**
     * Déplace le joueur sur le plateau.
     */
    private void deplacer(int deplacement) throws PersonnageHorsPlateauException {
        int nouvellePosition = playerPosition + deplacement;
        if (nouvellePosition >= taillePlateau) {
            throw new PersonnageHorsPlateauException(
                    joueur.getName() + " a dépassé la case finale (" + taillePlateau + ") !"
            );
        }
        playerPosition = nouvellePosition;
    }
}
