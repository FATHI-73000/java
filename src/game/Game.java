package game;

import characters.Character;
import menu.Menu;
import exceptions.PersonnageHorsPlateauException;

import java.util.ArrayList;

public class Game {

    private Character joueur;
    private int avancement = 0;
    private ArrayList<Cell> plateau;

    // Ajout de ces champs pour déplacer directement ici
    private int position = 0;
    private int taillePlateau = 4; // taille selon le nombre de cases du plateau
    private String name = "";

    public Game() {
        initialiserPlateau();
    }

    // Initialise le plateau avec les 4 cases
    private void initialiserPlateau() {
        plateau = new ArrayList<>();
        plateau.add(new EmptyCell(1));
        plateau.add(new EnemyCell(2));
        plateau.add(new WeaponCell(3));
        plateau.add(new PotionCell(4));
    }

    // Getter pour le plateau
    public ArrayList<Cell> getPlateau() {
        return plateau;
    }

    // Dé de 1 case (dé pipé)
    private int lancerDe() {
        return 1;
    }

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

            name = joueur.getName(); // On copie le nom du personnage pour le test
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
                            name = joueur.getName(); // met à jour le nom
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
                return; // Fin du jeu si exception
            }

            Cell caseActuelle = plateau.get(position);

            System.out.println("Vous avancez de " + de + " case(s).");
            System.out.println(caseActuelle); // Affiche la description de la case
        }

        System.out.println(genererMessageVictoire(name));
    }

    //  Intégration directe de la méthode de déplacement ici
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

    private String genererMessageVictoire(String nomPersonnage) {
        return "Bravo " + nomPersonnage + ", tu as terminé le donjon !";
    }
}
