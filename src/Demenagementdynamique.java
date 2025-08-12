
import java.util.Scanner;

public class Demenagementdynamique {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int totalCartons = 0;
        int capaciteCamion = 0;

        while (true) {
            System.out.print("Entrez le nombre total de cartons à déménager : ");
            if (clavier.hasNextInt()) {
                totalCartons = clavier.nextInt();
                if (totalCartons > 0) {
                    break;
                } else {
                    System.out.println("Veuillez entrer un nombre positif.");
                }
            } else {
                System.out.println("Ce n'est pas un nombre valide.");
                clavier.next();
            }
        }

        while (true) {
            System.out.print("Entrez la capacité du camion (en nombre de cartons) : ");
            if (clavier.hasNextInt()) {
                capaciteCamion = clavier.nextInt();
                if (capaciteCamion > 0) {
                    break;
                } else {
                    System.out.println("Veuillez entrer un nombre positif.");
                }
            } else {
                System.out.println("Ce n'est pas un nombre valide.");
                clavier.next();
            }
        }

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
}

