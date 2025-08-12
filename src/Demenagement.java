public class Demenagement { public static void main(String[] args) {
    // Valeurs codées en dur
    int totalCartons = 34;
    int capaciteCamion = 9;

    int cartonsRestants = totalCartons;

    // Boucle pour effectuer les voyages
    while (cartonsRestants > 0) {
        // Nombre de cartons dans ce voyage
        int cartonsCharge = Math.min(cartonsRestants, capaciteCamion);

        // Affichage du message
        System.out.println("Un voyage de " + cartonsCharge + " cartons.");

        // Mise à jour du nombre de cartons restants
        cartonsRestants = cartonsRestants - cartonsCharge;
    }
}
}

