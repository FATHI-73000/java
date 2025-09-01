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
    private int avancement = 0;
    private ArrayList<Cell> plateau;

    private int position = 0;
    private int taillePlateau = 4; // nombre de cases du plateau
    private String name = "";

    /**
     * Constructeur. Initialise le plateau de jeu.
     */
    public Game() {
        initialiserPlateau();
    }

    /**
     * Initialise le plateau avec 4 cases (vide, ennemi, arme, potion).
     */
    private void initialiserPlateau() {
        plateau = new ArrayList<>();
        plateau.add(new EmptyCell(1));
        plateau.add(new EnemyCell(2));
        plateau.add(new WeaponCell(3));
        plateau.add(new PotionCell(4));
    }

    /**
     * Retourne le plateau du jeu.
     *
     * @return La liste des cases du plateau
     */
    public ArrayList<Cell> getPlateau() {
        return plateau;
    }

    /**
     * Lance un dé pipé pour avancer de 1 case.
     *
     * @return la valeur du dé (toujours 1)
     */
    private int lancerDe() {
        return 1;
    }

    /**
     * Démarre le jeu et gère le menu principal.
     */
    public void startGame() {
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

            name = joueur.getName();
            System.out.println("Personnage créé : " + joueur);

            boolean enJeu = true;
            while (enJeu) {
                menu.afficherSousMenuPersonnage();
                int sousChoix = menu.lireChoixUtilisateur();

                switch (sousChoix) {
                    case 1:
                        System.out.println(joueur);
                        break;
                    case 2:
                        joueur = menu.creerPersonnage();
                        if (joueur == null) {
                            System.out.println("Personnage non modifié.");
                        } else {
                            name = joueur.getName();
                            System.out.println("Nouveau personnage : " + joueur);
                        }
                        break;
                    case 3:
                        jouer();
                        break;
                    case 4:
                        System.out.println("Merci d'avoir joué !");
                        enJeu = false;
                        break;
                    default:
                        System.out.println("Choix invalide.");
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
     * Boucle principale du jeu pour faire avancer le joueur sur le plateau.
     */
    private void jouer() {
        System.out.println("Début de la partie !");
        avancement = 0;
        position = 0;

        while (position < taillePlateau) {
            int de = lancerDe();

            try {
                deplacer(de);
            } catch (PersonnageHorsPlateauException e) {
                System.out.println("Erreur : " + e.getMessage());
                return;
            }

            Cell caseActuelle = plateau.get(position);
            System.out.println("Vous avancez de " + de + " case(s).");
            System.out.println(caseActuelle);
        }

        System.out.println(genererMessageVictoire(name));
    }

    /**
     * Déplace le joueur sur le plateau.
     *
     * @param deplacement le nombre de cases à avancer
     * @throws PersonnageHorsPlateauException si le joueur dépasse la dernière case
     */
    public void deplacer(int deplacement) throws PersonnageHorsPlateauException {
        int nouvellePosition = position + deplacement;
        if (nouvellePosition >= taillePlateau) {
            throw new PersonnageHorsPlateauException(
                    name + " a dépassé la case finale (" + taillePlateau + ") !"
            );
        }
        position = nouvellePosition;
        System.out.println(name + " se déplace à la case " + (position + 1));
    }

    /**
     * Génère un message de victoire pour le joueur.
     *
     * @param nomPersonnage le nom du joueur
     * @return le message de victoire
     */
    private String genererMessageVictoire(String nomPersonnage) {
        return "Bravo " + nomPersonnage + ", tu as terminé le donjon !";
    }
}
