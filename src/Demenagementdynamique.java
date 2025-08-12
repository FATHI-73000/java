
import java.util.Scanner;

public class Demenagementdynamique {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        int totalCartons = lireEntierPositif(clavier, "Entrez le nombre total de cartons à déménager : ");
        int capaciteCamion = lireEntierPositif(clavier, "Entrez la capacité du camion (en nombre de cartons) : ");

        int cartonsRestants = totalCartons;
        int numeroVoyage = 1;

        while (cartonsRestants > 0) {
            int cartonsCharge = Math.min(cartonsRestants, capaciteCamion);
            System.out.println("Voyage " + numeroVoyage + " : un voyage de " + cartonsCharge + " cartons.");
            cartonsRestants = cartonsRestants - cartonsCharge;
            numeroVoyage = numeroVoyage + 1;
        }

        clavier.close();
    }

    public static int lireEntierPositif(Scanner scanner, String message) {
        int valeur;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                valeur = scanner.nextInt();
                if (valeur > 0) {
                    return valeur;
                } else {
                    System.out.println("Veuillez entrer un nombre positif.");
                }
            } else {
                System.out.println("Ce n'est pas un nombre valide.");
                scanner.next();
            }
        }
    }
}
