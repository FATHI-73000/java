package game;

import characters.Character;
import menu.Menu;

public class Game {

    private Character joueur;  // Le joueur
    private int avancement = 0;  // Position sur le plateau

    public void startGame() {
        Menu menu = new Menu();

        // Affichage du menu principal
        menu.afficherMenuPrincipal();
        int choix = menu.lireChoixUtilisateur();

        if (choix == 1) {
            joueur = menu.creerPersonnage();  // Création personnage
            if (joueur == null) {
                System.out.println("Personnage non créé. Fin du jeu.");
                menu.fermerScanner();
                return;
            }
            System.out.println("Personnage créé : " + joueur);

            // Menu secondaire
            boolean enJeu = true;
            while (enJeu) {
                menu.afficherSousMenuPersonnage();
                int sousChoix = menu.lireChoixUtilisateur();

                switch (sousChoix) {
                    case 1:
                        System.out.println(joueur);
                        break;
                    case 2:
                        joueur = menu.creerPersonnage(); // Modifier personnage
                        if (joueur == null) {
                            System.out.println("Personnage non modifié.");
                        } else {
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
        avancement = 0; // remise à zéro avant partie
        while (avancement < 64) {
            int de = (int) (Math.random() * 6) + 1;
            avancement += de;
            if (avancement > 64) avancement = 64;
            System.out.println("Le joueur avance de " + de + " cases. Position : " + avancement + "/64");
        }
        System.out.println("🎉 Le joueur a atteint la fin du plateau !");
    }
}
