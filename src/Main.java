import characters.Warrior;
import characters.Wizard;
import exceptions.PersonnageHorsPlateauException;

public class Main {
    public static void main(String[] args) {

        // Taille du plateau
        int taillePlateau = 10;

        // Création des personnages
        Warrior thor = new Warrior("Thor", taillePlateau);
        Wizard merlin = new Wizard("Merlin", taillePlateau);

        // Déplacement de Thor
        try {
            thor.deplacer(5);  // Avance à la case 5
            thor.deplacer(6);  // Dépasse la case finale → exception
        } catch (PersonnageHorsPlateauException e) {
            System.out.println("⚠️ Exception : " + e.getMessage());
        }

        // Déplacement de Merlin
        try {
            merlin.deplacer(3);  // Avance à la case 3
            merlin.deplacer(8);  // Dépasse la case finale → exception
        } catch (PersonnageHorsPlateauException e) {
            System.out.println("⚠️ Exception : " + e.getMessage());
        }

        // Affichage final des personnages
        System.out.println(thor);
        System.out.println(merlin);
    }
}
