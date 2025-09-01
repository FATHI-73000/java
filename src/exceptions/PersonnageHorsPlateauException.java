package exceptions;

/**
 * Exception levée lorsqu'un personnage dépasse la case finale du plateau.
 */
public class PersonnageHorsPlateauException extends Exception {

    /**
     * Constructeur par défaut avec un message prédéfini.
     */
    public PersonnageHorsPlateauException() {
        super("Le personnage a dépassé la case finale !");
    }

    /**
     * Constructeur avec un message personnalisé.
     *
     * @param message Le message de l'exception
     */
    public PersonnageHorsPlateauException(String message) {
        super(message);
    }
}
