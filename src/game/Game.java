package game;

import characters.Character;
import menu.Menu;

public class Game {

    // Attribut qui représente le joueur actuel
    private Character joueur;

    // Position du joueur sur le plateau (0 = départ)
    private int avancement = 0;

    /**
     * Méthode principale qui démarre le jeu.
     * Gère l'affichage du menu, la création/modification du personnage,
     * et le déroulement de la partie.
     */
    public void startGame() {
        Menu menu = new Menu();  // Création d'un objet Menu pour interaction

        // Affichage du menu principal et lecture du choix utilisateur
        menu.afficherMenuPrincipal();
        int choix = menu.lireChoixUtilisateur();

        if (choix == 1) {
            // Création du personnage via le menu
            joueur = menu.creerPersonnage();

            if (joueur == null) {
                System.out.println("Personnage non créé. Fin du jeu.");
                menu.fermerScanner();
                return;
            }
            System.out.println("Personnage créé : " + joueur);

            // Boucle du menu secondaire tant que le joueur ne quitte pas
            boolean enJeu = true;
            while (enJeu) {
                menu.afficherSousMenuPersonnage();
                int sousChoix = menu.lireChoixUtilisateur();

                switch (sousChoix) {
                    case 1:
                        // Afficher les informations du personnage
                        System.out.println(joueur);
                        break;
                    case 2:
                        // Modifier le personnage (recréation)
                        joueur = menu.creerPersonnage();
                        if (joueur == null) {
                            System.out.println("Personnage non modifié.");
                        } else {
                            System.out.println("Nouveau personnage : " + joueur);
                        }
                        break;
                    case 3:
                        // Démarrer la partie
                        jouer();
                        break;
                    case 4:
                        // Quitter le jeu
                        System.out.println("Merci d'avoir joué !");
                        enJeu = false;
                        break;
                    default:
                        System.out.println("Choix invalide.");
                }
            }
        } else if (choix == 2) {
            // Quitter depuis le menu principal
            System.out.println("À bientôt !");
        } else {
            System.out.println("Choix invalide.");
        }

        // Fermeture du scanner pour libérer les ressources
        menu.fermerScanner();
    }

    /**
     * Méthode qui gère le déroulement du jeu.
     * Le joueur avance sur un plateau de 64 cases en lançant un dé.
     */
    private void jouer() {
        System.out.println("Début de la partie !");
        avancement = 0;  // Réinitialisation de la position avant la partie

        while (avancement < 64) {
            // Simulation d'un lancer de dé (1 à 6)
            int de = (int) (Math.random() * 6) + 1;
            avancement += de;

            // S'assurer que la position ne dépasse pas 64
            if (avancement > 64) avancement = 64;

            // Afficher la progression du joueur
            System.out.println("Le joueur avance de " + de + " cases. Position : " + avancement + "/64");
        }

        // Message de victoire lorsque le joueur atteint la fin du plateau
        System.out.println(genererMessageVictoire(joueur.getName()));
    }

    /**
     * Méthode utilitaire qui génère un message de victoire personnalisé.
     * @param nomPersonnage Le nom du personnage joueur
     * @return Le message de victoire formaté
     */
    private String genererMessageVictoire(String nomPersonnage) {
        return "🎉 Bravo " + nomPersonnage + ", tu as terminé le donjon !";
    }
}
