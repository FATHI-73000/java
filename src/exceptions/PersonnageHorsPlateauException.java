package exceptions;

public class PersonnageHorsPlateauException extends Exception {

    public PersonnageHorsPlateauException() {
        super("Le personnage a dépassé la case finale !");
    }

    public PersonnageHorsPlateauException(String message) {
        super(message);
    }
}
