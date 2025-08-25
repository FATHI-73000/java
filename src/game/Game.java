package game;

// ✅ Importation de classes depuis d'autres packages
import characters.Character;
import menu.Menu;

public class Game {

    // ✅ Attributs privés : encapsulation respectée
    private Character joueur;          // Le personnage du joueur
    private int avancement = 0;        // Position du joueur sur le plateau

    // ✅ Méthode principale appelée depuis Main
    public void startGame() {
        // ✅ Instanciation d’un menu
        Menu menu = new Menu();

        // ✅ Affichage du menu principal et lecture du choix
        menu.afficherMenuPrincipal();
        int choix = menu.lireChoixUtilisateur();

        if (choix == 1) {
            // ✅ Création d’un personnage via le menu
            joueur = menu.creerPersonnage();

            if (joueur == null) {
                System.out.println("Personnage non créé. Fin du jeu.");
                menu.fermerScanner(); // ✅ Nettoyage des ressources
                return;
            }

            // ✅ Affichage automatique grâce à toString()
            System.out.println("Personnage créé : " + joueur);

            // ✅ Boucle de gestion du menu secondaire
            boolean enJeu = true;
            while (enJeu) {
                menu.afficherSousMenuPersonnage();
                int sousChoix = menu.lireChoixUtilisateur();

                switch (sousChoix) {
                    case 1:
                        // ✅ Affichage des infos du personnage
                        System.out.println(joueur);
                        break;

                    case 2:
                        // ✅ Modification du personnage (remplacement)
                        joueur = menu.creerPersonnage();
                        if (joueur == null) {
                            System.out.println("Personnage non modifié.");
                        } else {
                            System.out.println("Nouveau personnage : " + joueur);
                        }
                        break;

                    case 3:
                        // ✅ Lancer la partie
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

        // ✅ Fermeture du Scanner proprement
        menu.fermerScanner();
    }

    // ✅ Méthode pour jouer une partie
    private void jouer() {
        System.out.println("Début de la partie !");
        avancement = 0;

        // ✅ Boucle de déplacement sur 64 cases
        while (avancement < 64) {
            int de = (int) (Math.random() * 6) + 1;
            avancement += de;
            if (avancement > 64) avancement = 64;
            System.out.println("Le joueur avance de " + de + " cases. Position : " + avancement + "/64");
        }

        // ✅ Message de victoire personnalisé
        System.out.println(genererMessageVictoire(joueur.getName()));
    }

    // ✅ Méthode avec paramètre et retour
    private String genererMessageVictoire(String nomPersonnage) {
        return "🎉 Bravo " + nomPersonnage + ", tu as terminé le donjon !";
    }
}
