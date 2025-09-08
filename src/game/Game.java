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
    private ArrayList<Cell> board;   // plateau de jeu
    private int playerPosition = 0;  // position du joueur sur le plateau
    private int taillePlateau = 4;   // nombre de cases du plateau
    private De de;                   // interface De

    /**
     * Constructeur. Initialise le plateau de jeu et le dé.
     */
    public Game() {
        initialiserPlateau();
        this.de = new DeNormal(); // ou new DePipe()
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

    // ---------------------
    // GESTION DU PLATEAU (collection d'objets)
    // ---------------------

    /** Affiche le contenu du plateau */
    public void listerPlateau() {
        System.out.println("Contenu du plateau :");
        for (Cell cell : board) {
            System.out.println(cell);
        }
    }

    /** Ajoute une nouvelle case au plateau */
    public void ajouterCase(Cell cell) {
        board.add(cell);
        System.out.println("Case ajoutée : " + cell);
    }

    /** Supprime une case selon sa position */
    public void supprimerCase(int position) {
        Cell trouve = null;
        for (Cell cell : board) {
            if (cell.getPosition() == position) {
                trouve = cell;
                break;
            }
        }
        if (trouve != null) {
            board.remove(trouve);
            System.out.println("Case supprimée : " + trouve);
        } else {
            System.out.println("Case position " + position + " introuvable !");
        }
    }

    /** Recherche une case selon sa position */
    public Cell rechercherCase(int position) {
        for (Cell cell : board) {
            if (cell.getPosition() == position) {
                System.out.println("Case trouvée : " + cell);
                return cell;
            }
        }
        System.out.println("Case position " + position + " introuvable !");
        return null;
    }

    // ---------------------
    // LOGIQUE DE JEU
    // ---------------------

    public ArrayList<Cell> getBoard() {
        return board;
    }

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

    /** Méthode principale pour jouer tout le plateau */
    private void jouer() {
        System.out.println("Début de la partie !");
        playerPosition = 0;

        while (playerPosition < taillePlateau) {
            playTurn();
        }

        System.out.println("Bravo " + joueur.getName() + ", tu as terminé le donjon !");
    }

    /** Gère un tour complet : lancer le dé, avancer, interaction avec la case */
    private void playTurn() {
        int resultatDe = de.lancer(); // ⚡ appel via l'interface De
        try {
            deplacer(resultatDe);
        } catch (PersonnageHorsPlateauException e) {
            System.out.println("Erreur : " + e.getMessage());
            playerPosition = taillePlateau; // fin du jeu
            return;
        }

        Cell caseActuelle = board.get(playerPosition);
        System.out.println(joueur.getName() + " avance de " + resultatDe +
                " case(s) et arrive à la case " + (playerPosition + 1));
        System.out.println(caseActuelle);
    }

    private void deplacer(int deplacement) throws PersonnageHorsPlateauException {
        int nouvellePosition = playerPosition + deplacement;
        if (nouvellePosition >= taillePlateau) {
            throw new PersonnageHorsPlateauException(
                    joueur.getName() + " a dépassé la case finale (" + taillePlateau + ") !"
            );
        }
        playerPosition = nouvellePosition;
    }

    /** Méthode de démo pour tester les manipulations de plateau */
    public void demoPlateau() {
        System.out.println("===== DEMO PLATEAU =====");
        listerPlateau();                      // liste initiale
        ajouterCase(new EnemyCell(5));        // ajout
        rechercherCase(3);                     // recherche
        supprimerCase(2);                     // suppression
        listerPlateau();                      // liste finale
        System.out.println("========================");
    }
}
